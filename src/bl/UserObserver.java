/*
Patrón de Comportamiento (Observer): UserObserver implementa el patrón Observer para notificar cambios en los datos a los observadores.
*/
package bl;

import models.User;

public interface UserObserver {
    void update(User user);
}
