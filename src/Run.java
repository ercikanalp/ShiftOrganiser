import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Mehmet"));
        employees.add(new Employee("Isa"));
        employees.add(new Employee("Murat"));
        employees.add(new Employee("Recep"));
        employees.add(new Employee("Mesut"));
        employees.add(new Employee("Sinan"));
        employees.add(new Employee("Samet"));
        employees.add(new Employee("Halit"));
        employees.add(new Employee("Okan"));
        employees.add(new Employee("Talha"));
        employees.add(new Employee("Levent"));
        employees.add(new Employee("Serkan"));


        Generate gen = new Generate(employees);
        gen.generate();

    }
}
