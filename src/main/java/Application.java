import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee("Name1", "Sur1", "nn", 32, 2);
        CityDAO cityDAO = new CityDAOImpl();
        List<Employee> employeeFromCity = List.of(employee1);
        City city1 = new City(7, "City2", employeeFromCity);
        cityDAO.createCity(city1);
        City city2 = new City("City1");
        cityDAO.createCity(city2);
        Employee employee2 = new Employee("Name2", "Sur2", "nn", 41, 3);
        employeeDAO.createEmployee(employee2);
        System.out.println(cityDAO.getCityById(6));
        List<City> cityList = cityDAO.getAllCities();
        for (City city : cityList) {
            System.out.println(city.getCity_name());
        }
        cityDAO.deleteCity(city1);
        cityDAO.getAllCities();
        City ct = new City(7, "Test");
        cityDAO.updateCity(ct);
        /*for (Employee employee : employeeList) {
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
        bookDAO.updateEmployee(employeetest3);*/
    }




}