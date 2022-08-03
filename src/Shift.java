import java.util.ArrayList;

public class Shift {
    private int capacity;
    private int id;

    private ArrayList<Employee> employees;

    public Shift(int capacity, int id) {
        employees = new ArrayList<>();
        this.capacity = capacity;
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
