package aTMManagementSystem.java;
import java.util.Scanner;
interface BankOperations {
    void deposit(double amount);

    void withdraw(double amount);

    void displayBalance();

    void addInterest();
}
class Account {
    private int accNo;
    private String name;
    private double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends Account implements BankOperations {
    SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount > getBalance()) {
            System.out.println("Insufficient balance");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void displayBalance() {
        System.out.println("Balance: " + getBalance());
    }

    public void addInterest() {
        double interest = getBalance() * 0.05;
        setBalance(getBalance() + interest);
        System.out.println("Interest added: " + interest);
    }

    public void displayDetails() {
        System.out.println("Acc No: " + getAccNo());
        System.out.println("Name: " + getName());
        System.out.println("Balance: " + getBalance());
    }
}

public class ATMManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAccount[] accounts = new SavingsAccount[3];
        // Predefined accounts
        accounts[0] = new SavingsAccount(101, "Hema", 9000);
        accounts[1] = new SavingsAccount(102, "varshitha", 2000);
        accounts[2] = new SavingsAccount(103, "Sharanya", 3000);
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        SavingsAccount current = null;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccNo() == accNo) {
                current = accounts[i];
                break;
            }
        }
        if (current == null) {
            System.out.println("Account not found");
            return;
        }
        int choice;
        do {
            System.out.println("\n1.Deposit");
            System.out.println("\n2.Withdraw");
            System.out.println("\n3.Balance");
            System.out.println("\n4.Interest");
            System.out.println("\n5.Details");
            System.out.println("\n6.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    current.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    current.withdraw(sc.nextDouble());
                    break;
                case 3:
                    current.displayBalance();
                    break;
                case 4:
                    current.addInterest();
                    break;
                case 5:
                    current.displayDetails();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);
    }
}
