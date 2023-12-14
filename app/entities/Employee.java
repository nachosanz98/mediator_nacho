package entities;


public class Employee {

	private int id;
    private String nombre;
    private String departamento;
    private int salario;

    public Employee(){
        this.id=0;
        this.nombre ="";
        this.departamento ="";
        this.salario =0;
    }

    public Employee(int id, String nombre, String departamento, int salario) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getDepartment() {
        return departamento;
    }

    public void setDepartment(String departamento) {
        this.departamento = departamento;
    }

    public int getSalary() {
        return salario;
    }

    public void setSalary(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", salario=" + salario +
                '}';
    }
}