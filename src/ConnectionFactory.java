import java.sql.*;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/raczagi07";
    public static final String USER = "root";
    public static final String PASSWORD = "Suti0077@";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
    public static void main(String[] args) throws SQLException {
        getConnection();
        Connection connection = getConnection();
        try (
        Statement statement = connection.createStatement();
        // PreparedStatement statement = connection.prepareStatement("SELECT*FROM user")

        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        ) {
            while ((resultSet.next())) {

                System.out.println(resultSet.getString("name"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();

        }
       // statement.close();
       // resultSet.close();
       // connection.close();


    UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getUser(2));
    }

}
