/*
Single Responsibility Principle (SRP) –Cada clase tiene una única responsabilidad. Por ejemplo, UserService gestiona la lógica de negocio.
*/

package bl;

import dal.UserDAO;
import models.User;
import java.util.List;

public class UserService extends UserSubject {
    private UserDAO userDAO = new UserDAO();

    public void registerUser(User user) {
        userDAO.addUser(user);
        notifyObservers(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
        notifyObservers(user);
    }

    public void deleteUser(int userId) {
        User user = userDAO.getUserById(userId);
        if (user != null) {
            userDAO.deleteUser(userId);
            notifyObservers(user);
        }
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
