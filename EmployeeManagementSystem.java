package employeeManagementSystem.java;
import java.util.*;

//Employee class
class Employee {
 int id;
 String name;
 double salary;

 Employee(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }
}

//Main class
public class EmployeeManagementSystem {

 static ArrayList<Employee> empList = new ArrayList<>();
 static Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {

     int choice;

     do {
         System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
         System.out.println("1. Add Employee");
         System.out.println("2. View Employees");
         System.out.println("3. Search Employee");
         System.out.println("4. Update Employee");
         System.out.println("5. Delete Employee");
         System.out.println("6. Exit");
         System.out.print("Enter choice: ");

         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 addEmployee();
                 break;
             case 2:
                 viewEmployees();
                 break;
             case 3:
                 searchEmployee();
                 break;
             case 4:
                 updateEmployee();
                 break;
             case 5:
                 deleteEmployee();
                 break;
             case 6:
                 System.out.println("Thank You!");
                 break;
             default:
                 System.out.println("Invalid Choice!");
         }

     } while (choice != 6);
 }

 static void addEmployee() {
     System.out.print("Enter ID: ");
     int id = sc.nextInt();

     sc.nextLine(); // buffer clear

     System.out.print("Enter Name: ");
     String name = sc.nextLine();

     System.out.print("Enter Salary: ");
     double salary = sc.nextDouble();

     empList.add(new Employee(id, name, salary));
     System.out.println("✅ Employee Added!");
 }

 static void viewEmployees() {
     if (empList.isEmpty()) {
         System.out.println("No Employees Found!");
         return;
     }

     for (Employee e : empList) {
         System.out.println("ID: " + e.id +
                            " | Name: " + e.name +
                            " | Salary: " + e.salary);
     }
 }

 static void searchEmployee() {
     System.out.print("Enter ID: ");
     int id = sc.nextInt();

     for (Employee e : empList) {
         if (e.id == id) {
             System.out.println("Found: " + e.name +
                                " | Salary: " + e.salary);
             return;
         }
     }
     System.out.println("Employee Not Found!");
 }

 static void updateEmployee() {
     System.out.print("Enter ID: ");
     int id = sc.nextInt();

     for (Employee e : empList) {
         if (e.id == id) {

             sc.nextLine();

             System.out.print("Enter New Name: ");
             e.name = sc.nextLine();

             System.out.print("Enter New Salary: ");
             e.salary = sc.nextDouble();

             System.out.println("Updated Successfully!");
             return;
         }
     }
     System.out.println("Employee Not Found!");
 }

 static void deleteEmployee() {
     System.out.print("Enter ID: ");
     int id = sc.nextInt();

     Iterator<Employee> it = empList.iterator();

     while (it.hasNext()) {
         Employee e = it.next();
         if (e.id == id) {
             it.remove();
             System.out.println("Deleted Successfully!");
             return;
         }
     }
     System.out.println("Employee Not Found!");
 }
	}


