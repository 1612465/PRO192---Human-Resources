public abstract class Staff{
    private int ID;
    private String name;
    private int age;
    private long hsl;
    private String startDay;
    private Department department;
    private int dayOff;
    protected long totalSalary;

    abstract void displayInformation();

    public int getID(){
        return ID;
    }
    public void setID(int ID ){
        this.ID = ID;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge() { 
        return age; 
    }
    public void setAge(int age) { 
        this.age = age; 
    }

    public long getHsl() {
        return hsl;
    }
    public void setHsl(long hsl) {
        this.hsl = hsl;
    }

    public String getStartDay() { 
        return startDay; 
    }
    public void setStartDay(String startDay) { 
        this.startDay = startDay; 
    }

    public Department getDepartment() { 
        return department; 
    }
    public void setDepartment(Department department) { 
        this.department = department; 
        this.department.addStaffInDepartment(this);
    }

    public int getDayOff(){
        return dayOff;
    }
    public void setDayOff(int dayOff ){
        this.dayOff = dayOff;
    }

    public long getTotalSalary(){
        return totalSalary;
    }
    public abstract void setTotalSalary(long hsl, int timeOver, long ltn, long lcb);

}