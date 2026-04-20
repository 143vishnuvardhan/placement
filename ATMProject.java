import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ATM {
    private double balance;
    private final List<String> history;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.history = new ArrayList<>();
        history.add("Account opened with balance: ₹" + initialBalance);
    }

    public void checkBalance() {
        System.out.printf("Current Balance: ₹%.2f%n", balance);
        history.add("Checked balance: ₹" + String.format("%.2f", balance));
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        System.out.printf("₹%.2f deposited successfully.%n", amount);
        history.add("Deposited: ₹" + String.format("%.2f", amount));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            history.add("Failed withdrawal attempt: ₹" + String.format("%.2f", amount));
            return;
        }
        balance -= amount;
        System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        history.add("Withdrawn: ₹" + String.format("%.2f", amount));
    }

    public void showHistory() {
        System.out.println("\n--- Transaction History ---");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (String record : history) {
            System.out.println(record);
        }
    }
}

public class ATMProject {

    private static int readChoice(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next(); // discard invalid input
        }
        return sc.nextInt();
    }

    private static double readAmount(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid amount: ");
            sc.next(); // discard invalid input
        }
        return sc.nextDouble();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(1000.00);

        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readChoice(sc);

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = readAmount(sc);
                    atm.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = readAmount(sc);
                    atm.withdraw(wit);
                    break;
                case 4:
                    atm.showHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
