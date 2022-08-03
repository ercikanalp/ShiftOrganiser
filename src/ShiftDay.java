import java.util.ArrayList;

public class ShiftDay {
    public ShiftDay(ArrayList<Shift> shifts, ArrayList<Employee> offDayEmployees ){
        this.shifts = shifts;
        this.offDayEmployees = offDayEmployees;
    }
    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public ArrayList<Employee> getOffDayEmployees() {
        return offDayEmployees;
    }
    public String[] getNames(){
        int totalEmployees = 0;
        for(Shift shift : shifts){
            totalEmployees += shift.getEmployees().size();
        }
        String[] names = new String[totalEmployees];
        int i = 0;
        for(Shift shift : shifts){
            for(Employee employee : shift.getEmployees()){
                names[i] = employee.getName();
                i++;
            }
        }
        return names;
    }

    private final ArrayList<Shift> shifts;
    private final ArrayList<Employee> offDayEmployees;


}
