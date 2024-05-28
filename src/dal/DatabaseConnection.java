package dal;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // private constructor to prevent instantiation
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        // logic to connect to the database
    }

    public void disconnect() {
        // logic to disconnect from the database
    }
}
