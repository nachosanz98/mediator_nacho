package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.DatabaseExecutionContext;
import services.EmployeeService;
import utils.ApplicationUtil;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

public class EmployeeController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    private final FormFactory formFactory;
    private final EmployeeService edb;
    private final HttpExecutionContext hec;
    private final DatabaseExecutionContext dec;

    @Inject
    public EmployeeController(FormFactory formFactory, EmployeeService employeeDBService, HttpExecutionContext hec, DatabaseExecutionContext dec){
        this.formFactory=formFactory;
        this.edb=employeeDBService;
        this.hec=hec;
        this.dec=dec;
    }

    public CompletionStage<Result> retrieve(int id) {

        Executor myEc = HttpExecution.fromThread(dec);
        logger.debug("In EmployeeController.retrieve(), retrieve employee with id: {}",id);

        return edb.getEmployee(id).thenApplyAsync(employee ->
                {
                    return ok(ApplicationUtil.createResponse(Json.toJson(employee), true));
                }
                , hec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        Employee employee = Json.fromJson(json, Employee.class);
        return edb.addEmployee(employee).thenApplyAsync(result -> {
            if (result) {
                return created(ApplicationUtil.createResponse(Json.toJson(employee), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error creating employee", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> listEmployees() {
        logger.debug("Fetching all employees...");
        return edb.getAllEmployees().thenApplyAsync(employees -> {
            JsonNode jsonData = Json.toJson(employees);
            logger.debug("Retrieved employees: {}", employees.toString());
            return ok(ApplicationUtil.createResponse(jsonData, true));
        }, hec.current());
    }

    public CompletionStage<Result> delete(int id) {
        logger.debug("In EmployeeController.retrieve(), delete employee with id: {}", id);
        return edb.deleteEmployee(id).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse("Employee with id: " + id + " deleted", true));
            } else {
                return notFound(ApplicationUtil.createResponse("Employee with id: " + id + " not found", false));
            }
        }, hec.current());
    }

    public CompletionStage<Result> update(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return CompletableFuture.completedFuture(
                    badRequest(ApplicationUtil.createResponse("Expecting JSON data", false))
            );
        }

        Employee employee = Json.fromJson(json, Employee.class);
        return edb.updateEmployee(employee).thenApplyAsync(result -> {
            if (result) {
                return ok(ApplicationUtil.createResponse(Json.toJson(employee), true));
            } else {
                return internalServerError(ApplicationUtil.createResponse("Error updating employee", false));
            }
        }, hec.current());
    }

}