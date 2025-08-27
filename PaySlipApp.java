import java.util.Scanner;
// Base class Employee
class Employee 
{
    String empName, empId, address, mailId;
    long mobileNo;
    double basicPay;
    Employee(String name, String id, String addr, String mail, long mobile, double bp) 
    {
        this.empName = name;
        this.empId = id;
        this.address = addr;
        this.mailId = mail;
        this.mobileNo = mobile;
        this.basicPay = bp;
    }
    void generatePaySlip() 
    {
        double DA = 0.97 * basicPay;
        double HRA = 0.10 * basicPay;
        double PF = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + DA + HRA;
        double netSalary = grossSalary - (PF + staffClubFund);
        System.out.println("\n--- Pay Slip ---");
        System.out.println("Employee Name : " + empName);
        System.out.println("Employee ID : " + empId);
        System.out.println("Address : " + address);
        System.out.println("Mail ID : " + mailId);
        System.out.println("Mobile Number : " + mobileNo);
        System.out.println("Basic Pay : " + basicPay);
        System.out.println("DA (97%) : " + DA);
        System.out.println("HRA (10%) : " + HRA);
        System.out.println("PF (12%) : " + PF);
        System.out.println("Staff Club Fund : " + staffClubFund);
        System.out.println("Gross Salary : " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
    }
}
// Derived classes
class Programmer extends Employee 
{
    Programmer(String n, String id, String addr, String mail, long mob, double bp)
    {super(n, id, addr, mail, mob, bp);}
}
class AssistantProfessor extends Employee
{
    AssistantProfessor(String n, String id, String addr, String mail, long mob, double bp) 
    {super(n, id, addr, mail, mob, bp);}
}
class AssociateProfessor extends Employee 
{
    AssociateProfessor(String n, String id, String addr, String mail, long mob, double bp) 
    {super(n, id, addr, mail, mob, bp);}
}
class Professor extends Employee 
{
    Professor(String n, String id, String addr, String mail, long mob, double bp) 
    {super(n, id, addr, mail, mob, bp);}
}
// Main class
public class PaySlipApp 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Employee Pay Slip Generator ---");
        System.out.println("1. Programmer"); 
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Address: ");
        String addr = sc.nextLine();
        System.out.print("Enter Mail ID: ");
        String mail = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        long mob = sc.nextLong();
        System.out.print("Enter Basic Pay: ");
        double bp = sc.nextDouble();
        Employee emp = null;
        switch (choice) 
        {
            case 1: emp = new Programmer(name, id, addr, mail, mob, bp); break;
            case 2: emp = new AssistantProfessor(name, id, addr, mail, mob, bp); break;
            case 3: emp = new AssociateProfessor(name, id, addr, mail, mob, bp); break;
            case 4: emp = new Professor(name, id, addr, mail, mob, bp); break;
            default: System.out.println("Invalid choice!"); System.exit(0);
        }
        // Generate pay slip
        emp.generatePaySlip();
        sc.close();
    }
}