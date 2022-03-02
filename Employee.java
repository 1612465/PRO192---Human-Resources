public class Employee extends Staff implements ICalculator{
    private int timeOver;
    long lcb=3000000;
    @Override
    void displayInformation() {
        System.out.println("ID : " + this.getID());
        System.out.println("Name : " + this.getName());
        System.out.println("Age : " + this.getAge());
        System.out.println("He so luong : " + this.getHsl());
        System.out.println("Start day : " + this.getStartDay());
        System.out.println("Department : " + this.getDepartment().getDepartmentName());
        System.out.println("Day Off : " + this.getDayOff());
        System.out.println("Time Over : " + this.getTimeOver());
        System.out.println("Salary : " + this.getTotalSalary());
    }

    public int getTimeOver() { 
        return timeOver; 
    }
    public void setTimeOver(int timeOver) {
      this.timeOver = timeOver;
    }
    public long getLcb(){
        return lcb; 
    }
    @Override
    public long calculateSalary(long hsl, int timeOver, long ltn, long lcb) {
        this.totalSalary=hsl*lcb + timeOver*200000 + ltn;
        return this.totalSalary;
    }

    @Override
    public void setTotalSalary(long hsl, int timeOver, long ltn, long lcb) {
        this.totalSalary=this.calculateSalary(hsl, timeOver, 0, lcb);
    }
}
