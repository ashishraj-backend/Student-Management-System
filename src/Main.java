public class Main {

    public static void main(String[] args) {

        Student student = new Student(
                1,
                "Ashish Raj",
                "Computer Science",
                20
        );

        StudentDAO studentDAO = new StudentDAO();

        studentDAO.addStudent(student);
    }
}
