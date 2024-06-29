
package studentmanagements;

public class Student{
    private int id;
    private String name;
    private int age;
    private String dob;
    private String gender;
    private int contact_number;
    
       
    public  Student(){
    }
       
    public  Student(int id,String name,int age,String dob,String gender,int contact_number){
        this.id=id;
        this.name=name;
        this.age=age;
        this.dob=dob;
        this.gender=gender;
        this.contact_number=contact_number;
        
    }
    
    public  Student(String name,int age,String dob,String gender,int contact_number){
        this.name=name;
        this.age=age;
        this.dob=dob;
        this.gender=gender;
        this.contact_number=contact_number;       
    }
       
       // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getdob() {
        return dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getcontact_number() {
        return contact_number;
    }

    public void setcontact_number(int contact_number) {
        this.contact_number = contact_number;
    }
}