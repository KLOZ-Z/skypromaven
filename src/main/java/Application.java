import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // Задаем параметры для подключения к базе данных:
        // имя пользователя, пароль и URL
        final String user = "postgres";
        final String password = "slavakakraft228";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee FULL OUTER JOIN city ON city.city_id = employee.city_id  WHERE id = 11")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Имя: " + resultSet.getString("first_name"));
                System.out.println("Фамилия: " + resultSet.getString("last_name"));
                System.out.println("Пол: " + resultSet.getString("gender"));
                System.out.println("Возраст: " + resultSet.getInt("age"));
                System.out.println("Город: " + resultSet.getString("city_name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }


        //task2
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
        bookDAO.deleteEmployee(12);

        System.out.println("\n");
        System.out.println("Task 2.4\n");

        Employee employeetest2 = new Employee(4,"name","surname","gender", 12,"city");
        bookDAO.createEmployee(employeetest2);

        System.out.println("\n");
        System.out.println("Task 2.5\n");
        Employee employeetest3 = new Employee(11,"name","surname","gender", 55,"city");
        bookDAO.updateEmployee(employeetest3);
    }




}