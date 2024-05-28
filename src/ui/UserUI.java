/*
D: Dependency Inversion Principle (DIP) – Las capas superiores (UserUI) dependen de abstracciones (UserObserver) y no de implementaciones concretas.
*/

package ui;

import bl.UserObserver;
import bl.UserService;
import models.User;
import java.util.List;
import java.util.Scanner;

public class UserUI implements UserObserver {
    private UserService userService = new UserService();

    public UserUI() {
        userService.addObserver(this);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Actualizar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Ver Usuarios");
            System.out.println("5. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Ingresar Nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresar Apellido:");
                    String apellido = scanner.nextLine();
                    User user = new User(0, nombre, apellido);
                    userService.registerUser(user);
                    break;
                case 2:
                    System.out.println("Ingresar ID del usuario que desee actualizar:");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); 
                    User existingUser = userService.getUsers().stream()
                        .filter(u -> u.getId() == idToUpdate)
                        .findFirst()
                        .orElse(null);
                    if (existingUser != null) {
                        System.out.println("Ingrese nuevo nombre:");
                        String newNombre = scanner.nextLine();
                        System.out.println("Ingrese nuevo apellido:");
                        String newApellido = scanner.nextLine();
                        User userToUpdate = new User(idToUpdate, newNombre, newApellido);
                        userService.updateUser(userToUpdate);
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese ID del usuario que desee eliminar:");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    userService.deleteUser(idToDelete);
                    break;
                case 4:
                    List<User> users = userService.getUsers();
                    for (User u : users) {
                        System.out.println("ID: " + u.getId() + ", Nombre: " + u.getNombre() + ", Apellido: " + u.getApellido());
                    }
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Intente de nuevo");
            }
        }
    }

    @Override
    public void update(User user) {
        System.out.println("Usuario Actualizado: " + user.getNombre());
    }

    public static void main(String[] args) {
        new UserUI().start();
    }
}
