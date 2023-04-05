import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String first_name;
    @Column(name = "last_name", length = 50, nullable = false)
    private String last_name;
    @Column(name = "gender", length = 10, nullable = false)
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "city_id")
    private int city;

    public Employee(int id, String first_name, String last_name, String gender, int age, int city){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    };

    public Employee(){};

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getGender() {
        return gender;
    }

    public int getCity() {
        return city;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCity(int city) {
        this.city = city;
    }
}
