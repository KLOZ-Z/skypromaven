import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee("Name1", "Sur1", "nn", 32,33);
        CityDAO cityDAO = new CityDAOImpl();
        List<Employee> employeeFromCity = List.of(employee1);
        City city1 = new City(12,"City2", employeeFromCity);
        cityDAO.createCity(city1);
        City city2 = new City("City1");
        cityDAO.createCity(city2);
        Employee employee2 = new Employee("Name2", "Sur2", "nn", 41, 33);
        employeeDAO.createEmployee(employee2);
        System.out.println(cityDAO.getCityById(6));
        List<City> cityList = cityDAO.getAllCities();
        for (City city : cityList) {
            System.out.println(city.getCity_name() + city.getCity_id());
        }
        City testdel = new City(62,"test");
        City ct = new City(45, "Test");
        cityDAO.deleteCity(testdel);
        cityDAO.updateCity(ct);
        cityList= cityDAO.getAllCities();
        for (City city : cityList) {
            System.out.println(city.getCity_name() + city.getCity_id());
        }

        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }




}