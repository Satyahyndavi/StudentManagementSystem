import java.util.*;
class Student {
    int studentId;
    String name;
    int age;
    String course;
    double marks;
   Scanner sc = new Scanner(System.in);
   void inputDetails() {
        System.out.print("Enter Student ID: ");
        studentId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Age: ");
        age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
    }
    void displayDetails() {
        System.out.println("--------------------------------");
        System.out.println("ID     : " + studentId);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
    }
}
public class studentmanagementsystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> list = new ArrayList<>();
    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Students with Marks Above X");
            System.out.println("5. Average Marks");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Update Student");
            System.out.println("8. Delete Student");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            if(sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }
            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    filterStudents();
                    break;
                case 5:
                    calculateAverage();
                    break;
                case 6:
                    sortStudents();
                    break;
                case 7:
                    updateStudent();
                    break;
                case 8:
                    deleteStudent();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 9);
    }
    static void addStudent() {
        Student s = new Student();
        s.inputDetails();
        list.add(s);
        System.out.println("Student added successfully!");
    }
    static void displayAll() {
        if (list.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for (Student s : list) {
            s.displayDetails();
        }
    }
    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (Student s : list) {
            if (s.studentId == id) {
                s.displayDetails();
                return;
            }
        }
        System.out.println("Student not found!");
    }
    static void filterStudents() {
        System.out.print("Enter marks value: ");
        double x = sc.nextDouble();

        boolean found = false;
        for (Student s : list) {
            if (s.marks > x) {
                s.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found above given marks!");
        }
    }

    static void calculateAverage() {
        if (list.isEmpty()) {
            System.out.println("No students!");
            return;
        }

        double sum = 0;
        for (Student s : list) {
            sum += s.marks;
        }

        double avg = sum / list.size();
        System.out.println("Average Marks: " + avg);
    }

    static void sortStudents() {
        Collections.sort(list, (a, b) -> Double.compare(b.marks, a.marks));
        System.out.println("Students sorted (High to Low)");
        displayAll();
    }
    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        for (Student s : list) {
            if (s.studentId == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new age: ");
                s.age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new course: ");
                s.course = sc.nextLine();
                System.out.print("Enter new marks: ");
                s.marks = sc.nextDouble();
                System.out.println("Updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.studentId == id) {
                it.remove();
                System.out.println("Deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}