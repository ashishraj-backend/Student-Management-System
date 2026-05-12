import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    // Add Student
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

    // View Students
    public void viewStudents() {

        String query = "SELECT * FROM students";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Course: " + resultSet.getString("course"));
                System.out.println("Age: " + resultSet.getInt("age"));

                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
