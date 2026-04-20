import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeManagement {

    // ----- Employee Class -----
    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void display() {
            System.out.println("---------------------------------");
            System.out.println("ID        : " + id);
            System.out.println("Name      : " + name);
            System.out.println("Department: " + department);
            System.out.println("Salary    : " + salary);
            System.out.println("---------------------------------");
        }
    }

    // ----- Main Logic -----
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Employee Management System ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employees.add(new Employee(id, name, dept, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found!");
                    } else {
                        for (Employee e : employees) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Employee e : employees) {
                        if (e.getId() == searchId) {
                            e.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    Iterator<Employee> iterator = employees.iterator();
                    boolean deleted = false;

                    while (iterator.hasNext()) {
                        Employee e = iterator.next();
                        if (e.getId() == deleteId) {
                            iterator.remove();
                            deleted = true;
                            System.out.println("Employee deleted successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}