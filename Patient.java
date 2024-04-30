package model;

public class Patient {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String contact;
    public Patient(){

    }

    public Patient(int id,String name,int age,String gender,String contact){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.contact=contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void SetContact(String contact){
        this.contact=contact;
    }

    public String getContact(){
        return contact;
    }

    public String toString(){
        return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", contact=" + contact +"]";
    }
}

