import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class UserDaoImpl implements UserDao{

    @Override
    public User getUser(int id) {
        try (Statement statement = ConnectionFactory.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        ) {
            if ((resultSet.next())) { // if : ha kapunk vissza eredményt

                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("password")
                        );
            }
        } catch (SQLException e){
            e.printStackTrace();

        }
                return null;
    }

    @Override
    public Set<User> getAllUsers() {
        return null;
    }
}
