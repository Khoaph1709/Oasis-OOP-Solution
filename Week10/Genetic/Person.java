public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected String address;

    /**
     * .
     */
    public Person() {
        name = null;
        age = 0;
        address = null;
    }

    /**
     * .
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Person p) {
        int nameCompare = name.compareTo(p.name);
        return nameCompare != 0
                ? nameCompare
                : Integer.compare(age, p.age);
    }

    @Override
    public String toString() {
        return "Person{" 
        + "name='" + name + '\'' 
        + ", age=" + age + ", address='" + address + '\'' + '}';
    }
}