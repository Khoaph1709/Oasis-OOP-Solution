public class Developer extends Employee {
    protected String programmingLanguage;
    protected int projectsCompleted;

    public Developer() {
        super();
        this.programmingLanguage = "Unknown";
        this.projectsCompleted = 0;
    }

    public Developer(String name, String id, double baseSalary, int yearsOfExperience, String programmingLanguage, int projectsCompleted) {
        super(name, id, baseSalary, yearsOfExperience);
        this.programmingLanguage = programmingLanguage;
        this.projectsCompleted = projectsCompleted;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    public void setProjectsCompleted(int projectsCompleted) {
        this.projectsCompleted = projectsCompleted;
    }

    public String getInfo() {
        return String.format("Developer(%s - %s,) - %s, %d projects", name, id, programmingLanguage, projectsCompleted);
    }

    public double calculateSalary() {
        return yearsOfExperience * 500 + projectsCompleted * 1000 + baseSalary;    
    }

    public String toString() {
        return String.format("Developer[name=%s,id=%s,baseSalary=%.2f,yearsOfExperience=%d,programmingLanguage=%s,projectsCompleted=%d]", name, id, baseSalary, yearsOfExperience, programmingLanguage, projectsCompleted);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Developer)) return false;
        Developer other = (Developer) obj;
        return super.equals(obj) && programmingLanguage.equals(other.programmingLanguage) && projectsCompleted == other.projectsCompleted;
    }
}
