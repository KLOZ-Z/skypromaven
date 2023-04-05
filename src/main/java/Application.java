import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("Task 2\n");
        EmployeeDAO bookDAO = new EmployeeDAOImpl();
        List<Employee> employeeList = bookDAO.getAllEmployees();

        for (Employee employee : employeeList) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Имя: " + employee.getFirst_name());
            System.out.println("Фамилия: " + employee.getLast_name());
            System.out.println("Пол: " + employee.getGender());
            System.out.println("Возраст: " + employee.getAge());
            System.out.println("Город: " + employee.getCity());
            System.out.println("\n");
        }

        System.out.println("\n");
        System.out.println("Task 2.2\n");
        Employee employeetest1 = bookDAO.getEmployeeById(11);
        System.out.println("ID: " + employeetest1.getId());
        System.out.println("Имя: " + employeetest1.getFirst_name());
        System.out.println("Фамилия: " + employeetest1.getLast_name());
        System.out.println("Пол: " + employeetest1.getGender());
        System.out.println("Возраст: " + employeetest1.getAge());
        System.out.println("Город: " + employeetest1.getCity());
        System.out.println("\n");

        System.out.println("\n");
        System.out.println("Task 2.3\n");
        bookDAO.deleteEmployee(10);

        System.out.println("\n");
        System.out.println("Task 2.4\n");

        Employee employeetest2 = new Employee(4,"name","surname","gender", 12,1);
        bookDAO.createEmployee(employeetest2);

        System.out.println("\n");
        System.out.println("Task 2.5\n");
        Employee employeetest3 = new Employee(11,"name","surname","gender", 99,1);
        bookDAO.updateEmployee(employeetest3);
    }




}