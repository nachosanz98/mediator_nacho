package services;

import entities.Employee;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                                        "SELECT id, name, department, salary FROM employee WHERE id="+id+";");

                                Employee newEmployee = new Employee();
                                while (rS.next()){
                                    newEmployee.setId(rS.getInt("id"));
                                    newEmployee.setName(rS.getString("name"));
                                    newEmployee.setDepartment(rS.getString("department"));
                                    newEmployee.setSalary(rS.getInt("salary"));
                                }
                                return newEmployee;
                            });
                },
                dec);
    }
    



    public CompletionStage<Boolean> addEmployee(Employee employee) {
        return CompletableFuture.supplyAsync(
                () -> {
                    return db.withConnection(
                            connection -> {
                                String sql_string = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
                                PreparedStatement statement = connection.prepareStatement(sql_string);

                                statement.setString(1, employee.getName());
                                statement.setString(2, employee.getDepartment());
                                statement.setInt(3, employee.getSalary());

                                int rowsInserted = statement.executeUpdate();

                                return rowsInserted > 0;
            });
        }, dec);
    }

    /*
    public CompletableFuture<Boolean> deleteEmployee(int id) {
        return CompletableFuture.supplyAsync(() -> {
            try (Connection connection = db.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
                statement.setInt(1, id);

                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }, dec);
    }

    public CompletionStage<Boolean> updateEmployee(Employee employee) {
        return CompletableFuture.supplyAsync(() -> {
            try (Connection connection = db.getConnection()) {
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?");

                statement.setString(1, employee.getName());
                statement.setString(2, employee.getDepartment());
                statement.setInt(3, employee.getSalary());
                statement.setInt(4, employee.getId());

                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }, dec);
    }

    public CompletionStage<List<Employee>> getAllEmployees() {
        return CompletableFuture.supplyAsync(() -> {
            List<Employee> employees = new ArrayList<>();

            try (Connection connection = db.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Employee employee = new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("department"),
                            resultSet.getInt("salary")
                    );
                    employees.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return employees;
        }, dec);
    }*/
}
