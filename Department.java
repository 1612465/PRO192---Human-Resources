import java.util.ArrayList;
import java.util.List;
public class Department {
    private String departmentID;
    private String departmentName;
    private int employeeInDepartment;
    private List<Staff> SID = new ArrayList<>();

    int number=1;
    public Department(String d){
        this.departmentID = d;
        this.departmentName = d;
        number++;
    }

    public String getDepartmentID() { return departmentID; }
    public void setDepartmentID(String departmentID) { this.departmentID = departmentID; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public int getEmployeeInDepartmentName() { return employeeInDepartment; }
    public void setEmployeeInDepartmentName(int employeeInDepartment) { this.employeeInDepartment = employeeInDepartment; }

    public List<Staff> getStaffInDepartment(){
        return SID;
    }

    public void addStaffInDepartment(Staff a){
        this.SID.add(a);
        this.employeeInDepartment++;
    }

    public String toString(){ 
        return "ID bộ phận: " + departmentID + "\n" +
               "Tên bộ phận: " + departmentName + "\n" +
               "Số nhân viên trong bộ phận: " + employeeInDepartment; 
    }
}
