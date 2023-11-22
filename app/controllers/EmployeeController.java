package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.EmployeeService;
import utils.ApplicationUtil;

import java.util.List;
import java.util.concurrent.CompletionStage;

public class EmployeeController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        Employee employee = Json.fromJson(json, Employee.class);
        logger.debug("In EmployeeController.create(), input is: {}", json.toString());
        CompletionStage<Boolean> createdEmployee = employeeService.addEmployee(employee);

        return (Result)createdEmployee.thenApplyAsync(result -> {
            if (result) {
                JsonNode jsonObject = Json.toJson(employee);
                return created(ApplicationUtil.createResponse(jsonObject, true));
            } else {
                return internalServerError("An error occurred");
            }
        });
    }

    public Result update(Http.Request request) {
        logger.debug("In EmployeeController.update()");
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        Employee employee = Json.fromJson(json, Employee.class);
        logger.debug("In EmployeeController.update(), employee is: {}",employee);

        Employee existingEmployee = (Employee) employeeService.getEmployee(employee.getId());

        if (existingEmployee == null) {
            return notFound(ApplicationUtil.createResponse("Employee with id:" + employee.getId() + " not found", false));
        }

        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        CompletionStage<Boolean> updatedEmployee = employeeService.updateEmployee(existingEmployee);

        return (Result)updatedEmployee.thenApplyAsync(result -> {
            if (result) {
                JsonNode jsonObject = Json.toJson(existingEmployee);
                return created(ApplicationUtil.createResponse(jsonObject, true));
            } else {
                return internalServerError("An error occurred");
            }
        });
    }

    public Result retrieve(int id) {
        logger.debug("In EmployeeController.retrieve(), retrieve employee with id: {}",id);
        Employee employee = (Employee) employeeService.getEmployee(id);

        if (employee == null) {
            return notFound(ApplicationUtil.createResponse("Employee with id:" + id + " not found", false));
        }

        JsonNode jsonObjects = Json.toJson(employee);
        logger.debug("In EmployeeController.retrieve(), result is: {}", jsonObjects.toString());

        return ok(ApplicationUtil.createResponse(jsonObjects, true));
    }

    public Result listEmployees() {
        List<Employee> result = (List<Employee>) employeeService.getAllEmployees();

        logger.debug("In EmployeeController.listEmployees(), result is: {}", result.toString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);

        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

    public Result delete(int id) {
        logger.debug("In EmployeeController.retrieve(), delete employee with id: {}",id);
        CompletionStage<Boolean> deletedEmployee = employeeService.deleteEmployee(id);

        return (Result) deletedEmployee.thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Employee with id:" + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Employee with id:" + id + " not found", false));
            }
        });
    }
}