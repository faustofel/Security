package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User getUserByName(String userName);
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUserById(Long id);

}
