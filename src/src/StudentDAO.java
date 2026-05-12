import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public void addStudent(Student student) {

        String query = "INSERT INTO students(name, course, age) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getCourse());
            preparedStatement.setInt(3, student.getAge());

            preparedStatement.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
