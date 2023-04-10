import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer city_id;
    @Column(name = "city_name", length = 50, nullable = false)
    private String city_name;
    @OneToMany(mappedBy = "cities", cascade = CascadeType.ALL)
    private List<Employee> employees;
    public City(int id, String city_name, List<Employee> employees){
        this.city_id =id;
        this.city_name = city_name;
        this.employees = employees;
    }

    public City(int id, String city_name){
        this.city_id =id;
        this.city_name = city_name;
    }

    public City(String city_name,List<Employee> employees ){
        this.city_name = city_name;
        this.employees = employees;
    }

    public City(String city_name){
        this.city_name = city_name;
    }

    public City(){}

    public Integer getCity_id() {
        return city_id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
