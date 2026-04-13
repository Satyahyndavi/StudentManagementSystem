package libraryManagement.java;
import java.util.*;
class Book {
 int id;
 String title;
 String author;
 boolean isIssued;

 Book(int id, String title, String author) {
     this.id = id;
     this.title = title;
     this.author = author;
     this.isIssued = false;
 }
}
public class LibraryManagement {

 static ArrayList<Book> books = new ArrayList<>();
 static Scanner sc = new Scanner(System.in);
 static void addBook() {
     System.out.print("Enter Book ID: ");
     int id = sc.nextInt();
     sc.nextLine(); // clear buffer

     System.out.print("Enter Title: ");
     String title = sc.nextLine();

     System.out.print("Enter Author: ");
     String author = sc.nextLine();

     books.add(new Book(id, title, author));
     System.out.println("✅ Book Added Successfully!");
 }
 static void viewBooks() {
     if (books.isEmpty()) {
         System.out.println("No books available.");
         return;
     }
     System.out.println("\n--- Book List ---");
     for (Book b : books) {
         System.out.println("ID: " + b.id +
                 " | Title: " + b.title +
                 " | Author: " + b.author +
                 " | Issued: " + (b.isIssued ? "Yes" : "No"));
     }
 }
 static void issueBook() {
     System.out.print("Enter Book ID to issue: ");
     int id = sc.nextInt();

     for (Book b : books) {
         if (b.id == id) {
             if (!b.isIssued) {
                 b.isIssued = true;
                 System.out.println("✅ Book Issued!");
             } else {
                 System.out.println("❌ Book already issued.");
             }
             return;
         }
     }
     System.out.println("❌ Book not found.");
 }

 // Return Book
 static void returnBook() {
     System.out.print("Enter Book ID to return: ");
     int id = sc.nextInt();

     for (Book b : books) {
         if (b.id == id) {
             if (b.isIssued) {
                 b.isIssued = false;
                 System.out.println("✅ Book Returned!");
             } else {
                 System.out.println("❌ Book was not issued.");
             }
             return;
         }
     }
     System.out.println("❌ Book not found.");
 }
 public static void main(String[] args) {

     int choice;

     do {
         System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
         System.out.println("1. Add Book");
         System.out.println("2. View Books");
         System.out.println("3. Issue Book");
         System.out.println("4. Return Book");
         System.out.println("5. Exit");
         System.out.print("Enter choice: ");
         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 addBook();
                 break;
             case 2:
                 viewBooks();
                 break;
             case 3:
                 issueBook();
                 break;
             case 4:
                 returnBook();
                 break;
             case 5:
                 System.out.println("Thank you!");
                 break;
             default:
                 System.out.println("Invalid choice!");
         }

     } while (choice != 5);
 }
}
