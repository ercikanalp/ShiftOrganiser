import java.util.ArrayList;

public class Generate {
    private static ArrayList<Employee> firstShifters;
    private static ArrayList<Employee> secondShifters;
    private static ArrayList<Employee> nightShifters;
    private static  ArrayList<Employee> employees;

    private static  String[] names;


    public Generate(ArrayList<Employee> employees) {
        this.employees = employees;
        // Copy employees list into another arraylist
        names = new String[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            names[i] = employees.get(i).getName();
        }

    }

    public void generate() {
        firstShifters = new ArrayList<>();
        secondShifters = new ArrayList<>();
        nightShifters = new ArrayList<>();
        String[][] schedule = new String[7][6];
        ShiftDay day1 = generateShiftDay(1);
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i);
            if (i == 3) {
                firstShifters.add(employees.get(i));
            } else if (i == 2) {
                secondShifters.add(employees.get(i));
            } else {
                nightShifters.add(employees.get(i));
            }
        }
        for (int i = 0; i < employees.size(); i++) {
            employees.remove(i);
        }
        // Make sure every employee takes a day off in the week
        
        ShiftDay day2 = generateShiftDay(2);
        ShiftDay day3 = generateShiftDay(3);
        ShiftDay day4 = generateShiftDay(4);
        ShiftDay day5 = generateShiftDay(5);
        ShiftDay day6 = generateShiftDay(6);
        ShiftDay day7 = generateShiftDay(7);
        // Create an arraylist of ShiftDays and add day1 to day7
        ArrayList<ShiftDay> shiftDays = new ArrayList<>();
        shiftDays.add(day1);
        shiftDays.add(day2);
        shiftDays.add(day3);
        shiftDays.add(day4);
        shiftDays.add(day5);
        shiftDays.add(day6);
        shiftDays.add(day7);
        // Create a ShiftWeek and add shiftDays to it
        ShiftWeek shiftWeek = new ShiftWeek(shiftDays);


    }

    public ShiftDay generateShiftDay(int dayNumber) {
        // So we need to create 7 days, each day has 3 shifts, first two shifts has 3 employees, last shift has 2 employees.
        Shift shift1;
        Shift shift2;
        Shift shift3;

        // Randomly select employees from the names list with respect to the capacity and add them to the shifts.
        if (dayNumber == 1) {
            System.out.println("Day 1");
            shift1 = new Shift(3, 1);
            shift2 = new Shift(3, 2);
            shift3 = new Shift(2, 3);
            for (int i = 0; i < shift1.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * employees.size());
                shift1.addEmployee(employees.get(randomIndex));
                firstShifters.add(shift1.getEmployees().get(i));
                employees.remove(randomIndex);
            }
            for (int i = 0; i < shift2.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * employees.size());
                shift2.addEmployee(employees.get(randomIndex));
                secondShifters.add(shift2.getEmployees().get(i));
                employees.remove(randomIndex);
            }
            for (int i = 0; i < shift3.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * employees.size());
                shift3.addEmployee(employees.get(randomIndex));
                nightShifters.add(shift3.getEmployees().get(i));
                employees.remove(randomIndex);
            }
            printDaily(shift1, shift2, shift3);
            // Add the shifts to the shiftDays.
            System.out.println("Off day takers: ");
            for(Employee employee : employees){
                System.out.print(employee.getName() + " ");
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            return getShiftDay(shift1, shift2, shift3);
        }
        if (dayNumber == 2 || dayNumber == 5) {
            System.out.println("Day " + dayNumber);
            shift1 = new Shift(4, 1);
            shift2 = new Shift(4, 2);
            shift3 = new Shift(2, 3);
            // Add the first-shifters to shift1
            for (int i = 0; i < shift1.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * firstShifters.size());
                shift1.addEmployee(firstShifters.get(randomIndex));
                firstShifters.remove(randomIndex);
            }
            // Add the second-shifters to shift2
            for (int i = 0; i < shift2.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * secondShifters.size());
                shift2.addEmployee(secondShifters.get(randomIndex));

                secondShifters.remove(randomIndex);
            }
            // Add the night-shifters to shift3
            for (int i = 0; i < shift3.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * nightShifters.size());
                shift3.addEmployee(nightShifters.get(randomIndex));
                nightShifters.remove(randomIndex);
            }
            setAllShifters(shift1, shift2, shift3);
            // Print employees in shift1, shift2, shift3.
            printDaily(shift1, shift2, shift3);
            // Add the shifts to the shiftDays.
            System.out.println("Off day takers: ");
            // Create an arraylist and copy  array names in it
            ArrayList<String> offDayTakers = new ArrayList<>();
            for(String name : names){
                offDayTakers.add(name);
            }
            ShiftDay day = getShiftDay(shift1, shift2, shift3);
            String [] dailyNames = day.getNames();
            // Compare offDayTakers and dailyNames, remove the names in dailyNames from offDayTakers.
            for(String name : dailyNames){
                offDayTakers.remove(name);
            }
            // Print offDayTakers.
            for(String name : offDayTakers){
                System.out.print(name + " ");
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            return day;
        } else {
            System.out.println("Day " + dayNumber);
            shift1 = new Shift(3, 1);
            shift2 = new Shift(3, 2);
            shift3 = new Shift(2, 3);
            // Add the first-shifters to shift1
            for (int i = 0; i < shift1.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * firstShifters.size());
                shift1.addEmployee(firstShifters.get(randomIndex));
                firstShifters.remove(randomIndex);
            }
            // Add the second-shifters to shift2
            for (int i = 0; i < shift2.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * secondShifters.size());
                shift2.addEmployee(secondShifters.get(randomIndex));

                secondShifters.remove(randomIndex);
            }
            // Add the night-shifters to shift3
            for (int i = 0; i < shift3.getCapacity(); i++) {
                int randomIndex = (int) (Math.random() * nightShifters.size());
                shift3.addEmployee(nightShifters.get(randomIndex));
                nightShifters.remove(randomIndex);
            }
            setAllShifters(shift1, shift2, shift3);
            // Print employees in shift1, shift2, shift3.
            printDaily(shift1, shift2, shift3);
            // Add the shifts to the shiftDays.
            System.out.println("Off day takers: ");
            // Create an arraylist and copy  array names in it
            ArrayList<String> offDayTakers = new ArrayList<>();
            for(String name : names){
                offDayTakers.add(name);
            }
            ShiftDay day = getShiftDay(shift1, shift2, shift3);
            String [] dailyNames = day.getNames();
            // Compare offDayTakers and dailyNames, remove the names in dailyNames from offDayTakers.
            for(String name : dailyNames){
                offDayTakers.remove(name);
            }
            // Print offDayTakers.
            for(String name : offDayTakers){
                System.out.print(name + " ");
            }
            System.out.println();


            System.out.println("------------------------------------------------------------------------");
            return getShiftDay(shift1, shift2, shift3);
        }

    }

    private ShiftDay getShiftDay(Shift shift1, Shift shift2, Shift shift3) {
        ArrayList<Shift> shifts = new ArrayList<Shift>();
        shifts.add(shift1);
        shifts.add(shift2);
        shifts.add(shift3);
        ShiftDay shiftDay = new ShiftDay(shifts, new ArrayList<Employee>());


        return shiftDay;
    }

    private void setAllShifters(Shift shift1, Shift shift2, Shift shift3) {
        // Add shift1 employees to first-shifters
        for (Employee employee : shift1.getEmployees()) {
            firstShifters.add(employee);
        }
        // Add shift2 employees to second-shifters
        for (Employee employee : shift2.getEmployees()) {
            secondShifters.add(employee);
        }
        // Add shift3 employees to night-shifters
        for (Employee employee : shift3.getEmployees()) {
            nightShifters.add(employee);
        }
    }

    private void printDaily(Shift shift1, Shift shift2, Shift shift3) {
        System.out.println("Shift 1: ");
        for (int i = 0; i < shift1.getEmployees().size(); i++) {
            System.out.print(shift1.getEmployees().get(i).getName() + " ");
        }
        System.out.println();
        // Print the cleaner for shift1.
        System.out.println("Cleaner for shift 1 : " + assignCleaners(shift1));
        System.out.println("Shift 2: ");
        for (int i = 0; i < shift2.getEmployees().size(); i++) {
            System.out.print(shift2.getEmployees().get(i).getName() + " ");
        }
        System.out.println();
        System.out.println("Cleaner for shift 2 : " + assignCleaners(shift2));
        System.out.println("Shift 3: ");
        for (int i = 0; i < shift3.getEmployees().size(); i++) {
            System.out.print(shift3.getEmployees().get(i).getName() + " ");
        }
        System.out.println();
        System.out.println("Cleaner for shift 3 : " + assignCleaners(shift3));
    }

    private String assignCleaners(Shift shift){
        // Randomly choose an employee from the shift to be the cleaner.
        int randomIndex = (int) (Math.random() * shift.getEmployees().size());
        Employee cleaner = shift.getEmployees().get(randomIndex);
        return cleaner.getName();
    }
}
