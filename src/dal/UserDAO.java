package dal;

import models.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users = new ArrayList<>();
    private int nextId = 1; // Counter for assigning IDs

    public void addUser(User user) {
        user.setId(nextId++);
        users.add(user);
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return;
            }
        }
    }

    public void deleteUser(int userId) {
        users.removeIf(user -> user.getId() == userId);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }
}
