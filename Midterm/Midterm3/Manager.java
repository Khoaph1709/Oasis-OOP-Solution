public class Manager extends Employee {
    protected String department;
    protected int teamSize;

    public Manager() {
        super();
        this.department = "Unknown";
        this.teamSize = 0;
    }

    public Manager(String name, String id, double baseSalary, int yearsOfExperience, String department, int teamSize) {
        super(name, id, baseSalary, yearsOfExperience);
        this.department = department;
        this.teamSize = teamSize;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getInfo() {
        return String.format("Manager(%s - %s,) - %s Department, Team of %d", name, id, department, teamSize);
    }

    public double calculateSalary() {
        return yearsOfExperience * 1000 + teamSize * 200 + baseSalary;    
    }

    public String toString() {
        return String.format("Manager[name=%s,id=%s,baseSalary=%.2f,yearsOfExperience=%d,teamSize=%d,department=%s]", name, id, baseSalary, yearsOfExperience, teamSize, department);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manager)) return false;
        Manager other = (Manager) obj;
        return super.equals(obj) && department.equals(other.department) && teamSize == other.teamSize;
    }
}
