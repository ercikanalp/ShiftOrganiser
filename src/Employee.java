public class Employee {
    private String name;
    private boolean nightShift = false;


    public Employee(String name){
        this.name = name;
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

}
