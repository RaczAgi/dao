import java.util.Set;
public interface UserDao {
    User getUser (int id); //READ
    Set<User> getAllUsers(); //READ

    // User getUserByUserNameAndPassword(String user, String password)

}
