public class Employee {
    private Integer id;
    private String first_name;
    private String last_name;
    private String gender;
    private Integer age;

    private String city;

    public Employee(int id, String first_name, String last_name, String gender, int age, String city){
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

    public String getCity() {
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

    public void setCity(String city) {
        this.city = city;
    }
}
