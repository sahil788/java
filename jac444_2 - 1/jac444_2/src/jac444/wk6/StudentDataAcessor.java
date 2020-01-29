package jac444.wk6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataAcessor implements AutoCloseable {

    private Connection connection;
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    public StudentDataAcessor(String mysqlConnStr) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS_NAME);
        connection = DriverManager.getConnection(mysqlConnStr);
    }

    public List<Student> getStudentList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from Students");
        ) {
            List<Student> StudentList = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Name = rs.getString("NAME");
                String Course = rs.getString("COURSE");
                int Grade = rs.getInt("GRADE");
                Student student = null;
                try {
                    student = new Student(ID, Name, Course, Grade);
                } catch (Exception e) {
                    Controller.showError(e);
                }
                StudentList.add(student);
            }
            return StudentList;
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}