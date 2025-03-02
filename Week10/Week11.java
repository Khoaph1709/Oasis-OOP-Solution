import java.util.ArrayList;
import java.util.List;

public class Week11<T extends Comparable<T>> {
    public void sortGeneric(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25, "123 Main St"));
        people.add(new Person("Alice", 20, "456 Elm St"));
        people.add(new Person("Alicu", 30, "789 Oak St"));
        
        // Create instance of Week11 with Person type
        Week11<Person> sorter = new Week11<>();
        
        // Print original list
        System.out.println("Before sorting:");
        for (Person p : people) {
            System.out.println(p);
        }
        
        // Sort the list
        sorter.sortGeneric(people);
        
        // Print sorted list
        System.out.println("\nAfter sorting:");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}