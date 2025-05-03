import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Manager && ((Manager) employee).getDepartment().equals(department)) {
                result.add(employee);
            }
        }
        return result;
    }

    public double getTotalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }
        return total;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder("Company Employees:\n");
        for (Employee employee : employees) {
            info.append(employee.getInfo()).append("\n");
        }
        return info.toString();
    }
}


