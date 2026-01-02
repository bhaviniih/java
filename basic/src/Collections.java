import java.util.*;

public class Collections{
    public static void main(String[] args){
        List<ConstructorsEncapsulationPerson> people = new ArrayList<>();

        people.add(new ConstructorsEncapsulationPerson("Dev 1", 15));
        people.add(new ConstructorsEncapsulationPerson("Dev 2", 20));
        people.add(new ConstructorsEncapsulationPerson("Dev 3", 24));

        for(ConstructorsEncapsulationPerson p : people){
            System.out.println(p.getName() + " " + p.getAge());
        }

        System.out.println("\nUsing Map:");

        Map<Integer, ConstructorsEncapsulationPerson> personMap = new HashMap<>();
        personMap.put(1, new ConstructorsEncapsulationPerson("Dev", 22));
        personMap.put(2, new ConstructorsEncapsulationPerson("Alex", 30));

        ConstructorsEncapsulationPerson p = personMap.get(2);
        System.out.println(p.getName() + " - " + p.getAge());
    }
}