import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentManagement {

    /**
     * Kiểm tra xem hai sinh viên có cùng lớp hay không.
     *
     * @param s1 Sinh viên thứ nhất.
     * @param s2 Sinh viên thứ hai.
     * @return Trả về true nếu hai sinh viên cùng lớp, false nếu không.
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    Student[] students = new Student[100]; // Mảng chứa sinh viên

    /**
     * Thêm một sinh viên mới vào mảng sinh viên.
     *
     * @param newStudent Sinh viên cần thêm vào mảng.
     */
    public void addStudent(Student newStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) { // Nếu vị trí trống, thêm sinh viên
                students[i] = newStudent;
                break;
            }
        }
    }

    /**
     * Trả về thông tin các sinh viên, nhóm theo lớp.
     *
     * @return Chuỗi chứa thông tin sinh viên nhóm theo lớp.
     */
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

    /**
     * Xóa một sinh viên khỏi mảng theo mã sinh viên.
     *
     * @param id Mã sinh viên cần xóa.
     */
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
}
