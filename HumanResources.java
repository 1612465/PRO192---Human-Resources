import java.util.*;
import java.util.Scanner;
public class HumanResources {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Staff> staff = new ArrayList<Staff>();
        Department dp;
        //Lưu các phần tử dưới dạng hashset không trùng
        Set<Department> dArray = new HashSet<>();

        ArrayList<String> manageTitle = new ArrayList<>();
        manageTitle.add("Business Leader");
        manageTitle.add("Project Leader");
        manageTitle.add("Technical Leader");

        int a;
        do {
            System.out.println("    PHẦN MỀM QUẢN LÝ NHÂN VIÊN");
            System.out.println(" Xin vui lòng chọn chức năng");
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
            System.out.println("2. Hiển thị các bộ phận trong công ty");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
            System.out.println("4. Thêm nhân viên mới vào công ty");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên ");
            System.out.println("6. Hiển thị bảng lương nhân viên theo thứ tự tăng dần");
            System.out.println("7. Hiển thị bảng lương nhân viên theo thứ tự giảm dần");
            System.out.println("8. Thoát");
        
        System.out.print("Vui lòng nhập lựa chọn của bạn : ");
        a = scan.nextInt();
        switch(a){
            case 1: 
                System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
                showS(staff);
                System.out.println("_________________");
                break;
            case 2: 
                System.out.println("2. Hiển thị các bộ phận trong công ty");
                showD(dArray);
                System.out.println("_________________");
                break;
            case 3: 
                System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
                showEfromD(dArray);
                System.out.println("_________________");
                break;
            case 4: 
                System.out.println("4. Thêm nhân viên mới vào công ty");
                System.out.print("Vui lòng nhập tên bộ phận: ");
                scan.nextLine();
                String dpName = scan.nextLine();
                dp = dArray.stream().filter(x -> dpName
                            .equalsIgnoreCase(x.getDepartmentName())).findAny().orElse(new Department(dpName));          
                dArray.add(dp);
                staff.add(addNew(manageTitle, dp, scan));
                System.out.println("_________________");
                break;
            case 5: 
                System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên ");
                Staff find = findEfromNandID(staff,scan);
                if(find == null){
                    System.out.println("Không tìm thấy nhân viên.");
                } 
                else {
                    find.displayInformation();
                }
                System.out.println("_________________");
                break;
            case 6: 
                System.out.println("6. Hiển thị bảng lương nhân viên theo thứ tự tăng dần");
                showSalaryUp(staff);
                System.out.println("_________________");
                break;
            case 7: 
                System.out.println("7. Hiển thị bảng lương nhân viên theo thứ tự giảm dần");
                showSalaryDown(staff);
                System.out.println("_________________");
                break;
            case 8: 
                System.out.println("8. Thoát");
                break;
            }
        }while(a!=8);
        scan.close();
    }
    
    
    // Hiển thị danh sách nhân viên hiện có trong công ty
    public static void showS(ArrayList<Staff> staff) {
        for (Staff e : staff) {
            e.displayInformation();
            System.out.println("_________________");
        }
    }  

    // Hiển thị các bộ phận trong công ty
    public static void showD(Set<Department> d) {
        for (Department department : d) {
            System.out.println(department);
            System.out.println("_________________");
        }
    }

    // Hiển thị các nhân viên theo từng bộ phận
    public static void showEfromD(Set<Department> d){
        for (Department department: d){
            System.out.println("\n");
            System.out.println("Department: " + department.getDepartmentName());
            for (Staff staff : department.getStaffInDepartment()) {
                staff.displayInformation();
                System.out.println("_________________");
            }
        }
    }

    
    //Thêm nhân viên hoặc thêm quản lý vào Staff
    public static Staff addNew(ArrayList<String> title ,Department department,Scanner scan) {
        System.out.println("Chọn vị trí mà bạn muốn thêm vào : 1. Nhân viên | 2. Quản lí ");
        int a = 0;
        Staff e;
        a = scan.nextInt();
        while (a != 1 && a != 2) {
            System.out.print("Bạn nhập sai vui lòng nhập lại:1. Nhân viên | 2. Quản lí ");
            a = scan.nextInt();
        }
        if (a == 1) {
            e = addNewE(department, scan);
        } else {
            e = addNewM(title ,department, scan);
        }
        return e;
    }

    //Tìm kiếm thông tin nhân viên theo tên hoặc theo ID
    public static Staff findEfroID(ArrayList<Staff> s, Scanner scan) {
        int idInput = scan.nextInt();
        return s.stream().filter(x -> idInput==(x.getID())).findAny().orElse(null);
    }

    //Tạo đối tượng employee để lưu thông tin nhân viên
    public static Employee addNewE(Department d,Scanner scan) {
        Employee employee = new Employee();
        employee.setDepartment(d);
        System.out.print("ID nhân viên: ");
        employee.setID(scan.nextInt());
        System.out.print("Tên: ");
        scan.nextLine();
        employee.setName(scan.nextLine());
        System.out.print("Tuổi: ");
        employee.setAge(scan.nextInt());
        System.out.print("Hệ số lương: ");
        employee.setHsl(scan.nextLong());
        System.out.print("Ngày bắt đầu: ");
        String dayStart = scan.next();
        employee.setStartDay(dayStart);
        System.out.print("Số ngày nghỉ phép: ");
        employee.setDayOff(scan.nextInt());
        System.out.print("Số giờ làm thêm: ");
        employee.setTimeOver(scan.nextInt());
        employee.setTotalSalary(employee.getHsl(), employee.getTimeOver(),0, employee.getLcb());
        return employee;
    }

    public static Manager addNewM(ArrayList<String> title,Department d,Scanner scan) {
        Manager manager = new Manager();
        manager.setDepartment(d);
        System.out.print("ID nhân viên: ");
        manager.setID(scan.nextInt());
        System.out.print("Tên: ");
        scan.nextLine();
        manager.setName(scan.nextLine());
        System.out.print("Tuổi: ");
        manager.setAge(scan.nextInt());
        System.out.print("Chức vụ: 1.Business Leader | 2.Project Leader | 3.Technical Leader ");
        int a = scan.nextInt();
        //so sánh title có chứa các kí tự như managerTitle hay không
        while (a!= 1 && a != 2 && a!=3){
            System.out.println("Nhập không chính xác vui lòng nhập lại:");
            System.out.println("1.Business Leader | 2.Project Leader | 3.Technical Leader");
            a = scan.nextInt();
        }
        long pc;
        String mTitle;
        if (a == 1){
            pc = 8000000;
            mTitle = "Business Leader";
        } else if (a == 3){
            pc = 6000000;
            mTitle = "Technical Leader";
        } else {
            pc = 5000000;
            mTitle = "Project Leader";
        }
        manager.setTitle(mTitle);
        System.out.print("Hệ số lương: ");
        manager.setHsl(scan.nextLong());
        System.out.print("Ngày bắt đầu: ");
        manager.setStartDay(scan.next());
        System.out.print("Số ngày nghỉ phép: ");
        manager.setDayOff(scan.nextInt());
        manager.setTotalSalary(manager.getHsl(), 0, pc,manager.getLcbM());
        return manager;
    }

    //Tìm kiếm thông tin nhân viên theo tên hoặc theo ID
    public static Staff findEfromNandID(ArrayList<Staff> s, Scanner scan) {
        System.out.println("Bạn muốn tìn kiếm : 1. Theo tên  2.Theo ID ");
        int a = scan.nextInt();
        while (a != 1 && a != 2) {
            System.out.print("Nhập sai vui lòng nhập lại:1. Theo tên  2.Theo ID ");
            a = scan.nextInt();
        }
        if (a == 1) {
            System.out.print("Theo tên: ");
            scan.nextLine();
            String name = scan.nextLine();
            return s.stream().filter(x -> name.equalsIgnoreCase(x.getName())).findAny().orElse(null);
        } else {
            System.out.println("Theo ID: ");
            int idInput = scan.nextInt();
            return s.stream().filter(x -> idInput==(x.getID())).findAny().orElse(null);
        }
    }

    //Hiển thị bảng lương nhân viên tăng dần
    public static void showSalaryUp(ArrayList<Staff> s){
        s.stream().sorted(Comparator.comparing(Staff::getTotalSalary)).forEach(Staff::displayInformation);
    }
 
    //Hiển thị bảng lương nhân viên giảm dần
    public static void showSalaryDown(ArrayList<Staff> s){
        s.stream().sorted(Comparator.comparing(Staff::getTotalSalary).reversed()).forEach(Staff::displayInformation);
    }

}
