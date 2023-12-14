package services;

import entities.Employee;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
public class EmployeeService {
    private final Database db;
    private final DatabaseExecutionContext dec;
    @Inject
    public EmployeeService(Database db, DatabaseExecutionContext dec) {
        this.db = db;
        this.dec = dec;
    }


    public CompletionStage<Employee> getEmployee(int id) {
        return CompletableFuture.supplyAsync(
                () -> {
                    return db.withConnection(
                            connection -> {
                                ResultSet rS = connection.createStatement().executeQuery(
                                        "SELECT id, nombre, departamento, salario FROM empleado WHERE id="+id+";");

                                Employee newEmployee = new Employee();
                                while (rS.next()){
                                    newEmployee.setId(rS.getInt("id"));
                                    newEmployee.setName(rS.getString("nombre"));
                                    newEmployee.setDepartment(rS.getString("departamento"));
                                    newEmployee.setSalary(rS.getInt("salario"));
                                }
                                return newEmployee;
                            });
                }, dec);
    }
    


    public CompletionStage<Boolean> addEmployee(Employee employee) {
        return CompletableFuture.supplyAsync(
                () -> {
                    return db.withConnection(
                            connection -> {
                                String sql_string = "INSERT INTO empleado (nombre, departamento, salario) VALUES (?, ?, ?)";
                                PreparedStatement statement = connection.prepareStatement(sql_string);

                                statement.setString(1, employee.getName());
                                statement.setString(2, employee.getDepartment());
                                statement.setInt(3, employee.getSalary());

                                int rowsInserted = statement.executeUpdate();

                                return rowsInserted > 0;
            });
        }, dec);
    }


    public CompletionStage<Boolean> deleteEmployee(int id) {
        return CompletableFuture.supplyAsync(
                () -> {
                    return db.withConnection(
                            connection -> {
                                String sql_string = "DELETE FROM empleado WHERE id = ?";
                                PreparedStatement statement = connection.prepareStatement(sql_string);

                                statement.setInt(1, id);

                                int rowsDeleted = statement.executeUpdate();

                                return rowsDeleted > 0;
                            }
                    );
                }, dec);
    }

    public CompletionStage<List<Employee>> getAllEmployees() {
        return CompletableFuture.supplyAsync(() ->
                        db.withConnection(connection -> {
                            List<Employee> employees = new ArrayList<>();
                            ResultSet rs = connection.createStatement().executeQuery("SELECT id, nombre, departamento, salario FROM empleado");
                            while (rs.next()) {
                                Employee employee = new Employee();
                                employee.setId(rs.getInt("id"));
                                employee.setName(rs.getString("nombre"));
                                employee.setDepartment(rs.getString("departamento"));
                                employee.setSalary(rs.getInt("salario"));
                                employees.add(employee);
                            }
                            return employees;
                        })
                , dec);
    }

    public CompletionStage<Boolean> updateEmployee(Employee employee) {
        return CompletableFuture.supplyAsync(() ->
                        db.withConnection(connection -> {
                            String sqlString = "UPDATE empleado SET nombre = ?, departamento = ?, salario = ? WHERE id = ?";
                            PreparedStatement statement = connection.prepareStatement(sqlString);

                            statement.setString(1, employee.getName());
                            statement.setString(2, employee.getDepartment());
                            statement.setInt(3, employee.getSalary());
                            statement.setInt(4, employee.getId());

                            int rowsUpdated = statement.executeUpdate();
                            return rowsUpdated > 0;
                        })
                , dec);
    }
}
