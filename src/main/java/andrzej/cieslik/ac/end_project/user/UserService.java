package andrzej.cieslik.ac.end_project.user;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}