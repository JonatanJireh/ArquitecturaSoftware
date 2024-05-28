package bl;

import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserSubject {
    private List<UserObserver> observers = new ArrayList<>();

    public void addObserver(UserObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(UserObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(User user) {
        for (UserObserver observer : observers) {
            observer.update(user);
        }
    }
}
