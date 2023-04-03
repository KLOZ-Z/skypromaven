import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final String user = "postgres";
    private final String password = "slavakakraft228";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee FULL OUTER JOIN city ON city.city_id = employee.city_id")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String Employee_name = resultSet.getString("first_name");
                String Employee_lastname = resultSet.getString("last_name");
                String Employee_gender = resultSet.getString("gender");
                String Employee_city = resultSet.getString("city_name");
                int Employee_age = resultSet.getInt("age");

                employees.add(new Employee(idOfEmployee, Employee_name, Employee_lastname, Employee_gender,Employee_age,Employee_city));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return employees;
    }


    @Override
    public Employee getEmployeeById(int findId) {
        Employee employee = new Employee();

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee FULL OUTER JOIN city ON city.city_id = employee.city_id  WHERE id ="+findId)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String Employee_name = resultSet.getString("first_name");
                String Employee_lastname = resultSet.getString("last_name");
                String Employee_gender = resultSet.getString("gender");
                String Employee_city = resultSet.getString("city_name");
                int Employee_age = resultSet.getInt("age");

               employee = new Employee(idOfEmployee, Employee_name, Employee_lastname, Employee_gender,Employee_age,Employee_city);

            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO employee(id, first_name, last_name,gender,age,city_id) VALUES (?,?,?,?,?,?)")){
            int i =1;
            statement.setInt(i++,employee.getId());
            statement.setString(i++,employee.getFirst_name());
            statement.setString(i++,employee.getLast_name());
            statement.setString(i++,employee.getGender());
            statement.setInt(i++,employee.getAge());
            statement.setInt(i++,2);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("UPDATE employee SET age = ? WHERE id = ?")){
            int i =1;
            statement.setInt(i++,employee.getAge());
            statement.setInt(i++,employee.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int findId) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employee WHERE id ="+findId)) {
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }
}
