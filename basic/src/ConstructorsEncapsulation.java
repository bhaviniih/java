public class ConstructorsEncapsulation{
    public static void main(String[] args){

        ConstructorsEncapsulationPerson p1 = new ConstructorsEncapsulationPerson("Dev 1", 99);
        p1.sayHello();


        p1.setAge(125);

        System.out.println("set Age " + p1.getAge());

    }
}