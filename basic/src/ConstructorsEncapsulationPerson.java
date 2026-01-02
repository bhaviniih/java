public class ConstructorsEncapsulationPerson{

    private String name;
    private int age;

    // Constructor
    public ConstructorsEncapsulationPerson(String name, int age){
        this.name = name;
        this.age = age;
    }

    // Getter
    public String getName(){
        return name;
    }

    // Setter
    public void setName(String name){
        this.name = name;
    }

    // Getter
    public int getAge(){
        return age;
    }

    // Setter
    public void setAge(int age){
        if(age > 0){
            this.age = age;
        }
    }

    public void sayHello(){
        System.out.println("Hello, my name is " + name + ", age " + age);
    }
}