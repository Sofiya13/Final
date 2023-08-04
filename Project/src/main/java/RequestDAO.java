import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/register";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_USER_SQL = "INSERT INTO info (username, fabric_type, sample_quantity, contact, date) VALUES (?, ?, ?, ?, ?)";

    public RequestDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(Client_request user) {
        try (Connection connection = getConnection();
        	       PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFabricType());
            preparedStatement.setInt(3, user.getSampleQuantity());
            preparedStatement.setString(4, user.getContact());
            preparedStatement.setDate(5, new java.sql.Date(user.getDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
