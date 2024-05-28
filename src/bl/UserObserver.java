/*
Patrón de Comportamiento (Observer): UserObserver implementa el patrón Observer para notificar cambios en los datos a los observadores.
I: Interface Segregation Principle (ISP) –Se utilizan interfaces (UserObserver) para asegurar que las clases no sean forzadas a implementar métodos que no necesitan.
*/
package bl;

import models.User;

public interface UserObserver {
    void update(User user);
}
