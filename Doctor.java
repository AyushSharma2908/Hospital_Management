package model;

public class Doctor {

    private int id;
    private String name;
    private String specialization;
    private String contact;

    public Doctor(){

    }

    public Doctor(int id,String name,String specialization,String contact){
        this.id=id;
        this.name=name;
        this.specialization=specialization;
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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", contact=" + contact +"]";
    }
}
