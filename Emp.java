import java.util.Scanner;

class Employee {
    int empNo;
    String empName;
    String joinDate;
    String dept;
    char designationCode;
    int basic;
    int hra;
    int it;

    public Employee(int empNo, String empName, String joinDate, String dept, char designationCode, int basic, int hra, int it) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.dept = dept;
        this.designationCode = designationCode;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
    public int calculateSalary(int da) {
        return basic + hra + da - it;
    }
}

public class Emp {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee(1001, "Ashish", "01/04/2009", "R&D", 'e', 20000, 8000, 3000),
            new Employee(1002, "Sushma", "23/08/2012", "PM", 'c', 30000, 12000, 9000),
            new Employee(1003, "Rahul", "12/11/2008", "Acct", 'k', 10000, 8000, 1000),
            new Employee(1004, "Chahat", "29/01/2013", "Front", 'r', 12000, 6000, 2000),
            new Employee(1005, "Ranjan", "16/07/2005", "Engg", 'm', 50000, 20000, 20000),
            new Employee(1006, "Suman", "01/01/2000", "Manufacturing", 'e', 23000, 9000, 4400),
            new Employee(1007, "Tanmay", "12/06/2006", "PM", 'c', 29000, 12000, 10000),
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int empId = scanner.nextInt();

        boolean employeeFound = false;

        for (Employee emp : employees) {
            if (emp.empNo == empId) {
                employeeFound = true;
                int da = getDA(emp.designationCode);
                if (da == -1) {
                    System.out.println("Invalid designation code.");
                    break;
                }

                int salary = emp.calculateSalary(da);
                String designation = getDesignation(emp.designationCode);

                System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
                System.out.printf("%d\t%s\t\t%s\t\t%s\t\t%d\n", emp.empNo, emp.empName, emp.dept, designation, salary);
                break;
            }
        }

        if (!employeeFound) {
            System.out.println("There is no employee with empid: " + empId);
        }

        scanner.close();
    }

    public static int getDA(char designationCode) {
        switch (designationCode) {
            case 'e':
                return 20000;
            case 'c':
                return 32000;
            case 'k':
                return 12000;
            case 'r':
                return 15000;
            case 'm':
                return 40000;
            default:
                return -1; 
        }
    }

    public static String getDesignation(char designationCode) {
        switch (designationCode) {
            case 'e':
                return "Engineer";
            case 'c':
                return "Consultant";
            case 'k':
                return "Clerk";
            case 'r':
                return "Receptionist";
            case 'm':
                return "Manager";
            default:
                return "Unknown";
        }
    }
}
