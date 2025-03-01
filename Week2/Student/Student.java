public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    /**
     * Lấy tên của sinh viên.
     *
     * @return Tên của sinh viên.
     */
    public String getName() {
        return name;
    }

    /**
     * Cập nhật tên của sinh viên.
     *
     * @param name Tên mới của sinh viên.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Lấy mã sinh viên.
     *
     * @return Mã sinh viên.
     */
    public String getId() {
        return id;
    }

    /**
     * Cập nhật mã sinh viên.
     *
     * @param id Mã sinh viên mới.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Lấy tên nhóm của sinh viên.
     *
     * @return Tên nhóm của sinh viên.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Cập nhật tên nhóm của sinh viên.
     *
     * @param group Tên nhóm mới của sinh viên.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Lấy địa chỉ email của sinh viên.
     *
     * @return Địa chỉ email của sinh viên.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Cập nhật địa chỉ email của sinh viên.
     *
     * @param email Địa chỉ email mới của sinh viên.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Khởi tạo đối tượng sinh viên với các giá trị mặc định.
     */
    public Student() {
        name = "Student";
        id = "000";
        group = "K62CB";
        email = "uet@vnu.edu.vn";
    }

    /**
     * Khởi tạo đối tượng sinh viên với tên, mã sinh viên và email.
     *
     * @param name  Tên sinh viên.
     * @param id    Mã sinh viên.
     * @param email Địa chỉ email của sinh viên.
     */
    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
        group = "K62CB";
    }

    /**
     * Sao chép thông tin từ một đối tượng sinh viên khác.
     *
     * @param s Đối tượng sinh viên cần sao chép.
     */
    public Student(Student s) {
        name = s.name;
        id = s.id;
        group = s.group;
        email = s.email;
    }

    /**
     * Lấy thông tin chi tiết của sinh viên.
     *
     * @return Chuỗi chứa thông tin của sinh viên (Tên - Mã sinh viên - Nhóm - Email).
     */
    public String getInfo() {
        return name + " - " + id + " - " + group + " - " + email;
    }
}
