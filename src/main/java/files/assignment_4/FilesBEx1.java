package files.assignment_4;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;

public class FilesBEx1 {

    public static void main(String[] args) throws IOException {

        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeFile file = new EmployeeFile(employees);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        boolean working = true;
        while (working) {

            System.out.println();
            System.out.println("1. Open file");
            System.out.println("2. Save file");
            System.out.println("3. Add a record");
            System.out.println("4. Delete a record");
            System.out.println("5. Modify a record");
            System.out.println("6. Display all");
            System.out.println("7. Quit");

            int sel = 0;
            while (sel == 0) {
                System.out.print("Please select an option: ");
                sel = Integer.parseInt(input.readLine());
                if (sel > 7 || sel < 1) {
                    System.out.println("Please select a valid option");
                    sel = 0;
                }
            }

            switch (sel) {
                case 1 -> {
                    file.open();
                    System.out.println("File opened");
                }
                case 2 -> {
                    file.save();
                    System.out.println("File saved");
                }
                case 3 -> {
                    file.addRecord();
                    System.out.println("Record added");
                }
                case 4 -> {
                    file.deleteRecord();
                    System.out.println("Record deleted");
                }
                case 5 -> {
                    file.modifyRecord();
                    System.out.println("Record modified");
                }
                case 6 -> {
                    file.displayAll();
                }
                case 7 -> {
                    working = false;
                }
            }
        }
    }
}

class EmployeeFile {

    private ArrayList<Employee> employees;

    public EmployeeFile(ArrayList<Employee> employees) {

        this.employees = employees;
    }

    public void open() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/files/assignment_4/files/Employee.txt"));

        String line;
        int temp = 0;
        while ((line = reader.readLine()) != null) {

            String[] employeeData = line.split(" ");
            if (temp == 0) temp++;
            else {

                String num = employeeData[0], name = employeeData[1], status = employeeData[2], age = employeeData[3], salary = employeeData[4];

                employees.add(new Employee(num, name, status, age, salary));
            }
        }
        reader.close();

    }

    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/files/assignment_4/files/Employee.txt"));

        writer.write("Employee# Employee Name Marital Status Age Salary");
        for (Employee employee : employees) {
            writer.newLine();
            writer.write(employee.getEmployeeNumber() + " " + employee.getEmployeeName() + " " + employee.getMaritalStatus() + " " + employee.getAge() + " " + employee.getSalary());
        }
        writer.close();
    }

    public void addRecord() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter employee number: ");
        String num = input.readLine();
        System.out.print("Enter employee name: ");
        String name = input.readLine();
        System.out.print("Enter employee marital status: ");
        String status = input.readLine();
        System.out.print("Enter employee age: ");
        String age = input.readLine();
        System.out.print("Enter employee salary: ");
        String salary = input.readLine();
        employees.add(new Employee(num, name, status, age, salary));
    }

    public void deleteRecord() throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int pos = 1;
        for (Employee employee : employees) {
            System.out.println(pos + ". " + employee.getEmployeeName() + " #" + employee.getEmployeeNumber());
            pos++;
        }

        int selection = 0;
        while (selection == 0) {
            System.out.print("Please select on of the previously listed people: ");
            selection = Integer.parseInt(input.readLine());

            if (selection > employees.size()) {
                System.out.println("Please select a valid person");
                selection = 0;
            }
        }

        employees.remove(selection - 1);
    }

    public void modifyRecord() throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int pos= 1;
        for (Employee employee : employees) {
            System.out.println(pos + ". " + employee.getEmployeeName() + " #" + employee.getEmployeeNumber());
            pos++;
        }

        int selection1 = 0;
        while (selection1 == 0) {
            System.out.print("Please select on of the previously listed people: ");
            selection1 = Integer.parseInt(input.readLine());

            if (selection1 > employees.size() || selection1 < 1) {
                System.out.println("Please select a valid person");
                selection1 = 0;
            }
        }

        boolean modifying = true;
        while (modifying) {
            System.out.println();
            System.out.println("1. Employee#");
            System.out.println("2. Employee Name");
            System.out.println("3. Marital Status");
            System.out.println("4. Age");
            System.out.println("5. Salary");
            System.out.println("6. Exit");
            System.out.print("Please select an item to modify: ");

            int selection2 = 0;
            while (selection2 == 0) {
                System.out.print("Please select an item to modify: ");
                selection2 = Integer.parseInt(input.readLine());

                if (selection2 > 6 || selection2 < 1) {
                    System.out.println("Please select a valid item");
                    selection2 = 0;
                }
            }

            String newItem;
            switch (selection2) {
                case 1 -> {
                    System.out.print("Enter new employee number: ");
                    employees.get(selection1 - 1).setEmployeeNumber(input.readLine());
                }
                case 2 -> {
                    System.out.print("Enter new employee name: ");
                    employees.get(selection1 - 1).setEmployeeName(input.readLine());
                }
                case 3 -> {
                    System.out.print("Enter new marital status: ");
                    employees.get(selection1 - 1).setMaritalStatus(input.readLine());
                }
                case 4 -> {
                    System.out.print("Enter new age: ");
                    employees.get(selection1 - 1).setAge(input.readLine());
                }
                case 5 -> {
                    System.out.print("Enter new salary: ");
                    employees.get(selection1 - 1).setSalary(input.readLine());
                }
                case 6 -> {
                    modifying = false;
                }
            }
        }
    }

    public void displayAll() {
        System.out.println("Employee#\t\tEmployee Name\t\t\tMarital Status\t\tAge\t\t\tSalary");
        for (Employee e : employees) {
            System.out.format("%-15s %-23s %-19s %-11s %s\n", e.getEmployeeNumber(), e.getEmployeeName(), e.getMaritalStatus(), e.getAge(), e.getSalary());
        }
    }
}

@Getter
@Setter
class Employee {

    private String employeeNumber;
    private String employeeName;
    private String maritalStatus;
    private String age;
    private String salary;

    public Employee(String employeeNumber, String employeeName, String maritalStatus, String age, String salary) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.maritalStatus = maritalStatus;
        this.age = age;
        this.salary = salary;
    }
}
