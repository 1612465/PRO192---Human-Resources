public class Manager  extends Staff implements ICalculator{
    private String title;
    long lcb = 5000000;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    void displayInformation() {
        System.out.println("ID : " + this.getID());
        System.out.println("Name : " + this.getName());
        System.out.println("Age : " + this.getAge());
        System.out.println("Title : " + this.getTitle());
        System.out.println("He so luong : " + this.getHsl());
        System.out.println("Start day : " + this.getStartDay());
        System.out.println("Department : " + this.getDepartment().getDepartmentName());
        System.out.println("Day Off : " + this.getDayOff());
        System.out.println("Salary : " + this.getTotalSalary());
        
    }

    public long getLcbM(){
        return lcb;
    }

    @Override
    public long calculateSalary(long hsl, int timeOver, long ltn, long lcb) {
        this.totalSalary=hsl*lcb + ltn + timeOver;
        return this.totalSalary;
    }

    @Override
    public void setTotalSalary(long hsl, int timeOver, long ltn, long lcb) {
        this.totalSalary=this.calculateSalary(hsl, 0, ltn, lcb);        
    }
    
}
