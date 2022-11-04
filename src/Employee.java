public class Employee {
    private String name;
    private boolean offDay;
    private boolean nightShift = false;


    public Employee(String name){
        this.name = name;
        this.offDay = false;
    }
    public boolean hasWorkedAtNight(){
        return nightShift;
    }
    public void setNightShiftTrue(){
        nightShift = true;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNightShift() {
        return nightShift;
    }

    public void setNightShift(boolean nightShift) {
        this.nightShift = nightShift;
    }

    public void setOffDay(boolean offDay) {
        this.offDay = offDay;
    }

    public boolean isOffDay() {
        return offDay;
    }

}
