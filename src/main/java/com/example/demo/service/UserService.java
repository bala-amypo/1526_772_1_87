public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);
}
