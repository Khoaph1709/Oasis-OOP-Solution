import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentManagement {

    // Kiểm tra 2 sinh viên có cùng lớp hay không
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    Student[] students = new Student[100]; // Mảng chứa sinh viên

    // Thêm sinh viên vào mảng
    public void addStudent(Student newStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) { // Nếu vị trí trống, thêm sinh viên
                students[i] = newStudent;
                break;
            }
        }
    }

    public String studentsByGroup() {
        StringBuilder result = new StringBuilder();
        Map<String, List<Student>> groupedStudents = new LinkedHashMap<>();

        for (Student student : students) {
            if (student != null) { 
                String group = student.getGroup();
                if (!groupedStudents.containsKey(group)) {
                    groupedStudents.put(group, new ArrayList<>());
                }
                groupedStudents.get(group).add(student);
            }
        }

        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            result.append(entry.getKey()).append("\n"); 
            for (Student student : entry.getValue()) {
                result.append(student.getInfo()).append("\n"); 
            }
        }

        return result.toString().trim(); 
    }

    public void removeStudent(String id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId().equals(id)) {
                students[i] = null;
                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[students.length - 1] = null;
            }
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Nguyen Van A", "17020001", "1");
        Student s2 = new Student("Nguyen Van B", "17020002", "2");
        Student s3 = new Student("Nguyen Van C", "17020003", "1");

        StudentManagement manager = new StudentManagement();
        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addStudent(s3);

        System.out.println(manager.studentsByGroup());
        
        manager.removeStudent("17020002");

        System.out.println(manager.studentsByGroup());
    }
}