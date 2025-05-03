public abstract class Employee {
    protected String name;
    protected String id;
    protected double baseSalary;
    protected int yearsOfExperience;

    public Employee() {
        this.name = "Unknown";
        this.id = "0000";
        this.baseSalary = 0.0;
        this.yearsOfExperience = 0;
    }

    public Employee(String name, String id, double baseSalary, int yearsOfExperience) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public abstract String getInfo();

    public abstract double calculateSalary();

    public String toString() {
        return String.format("Employee[name=%s,id=%s,baseSalary=%.2f,yearsOfExperience=%d]", name, id, baseSalary, yearsOfExperience);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.baseSalary, baseSalary) == 0 &&
               yearsOfExperience == employee.yearsOfExperience &&
               name.equals(employee.name) &&
               id.equals(employee.id);
    }
}