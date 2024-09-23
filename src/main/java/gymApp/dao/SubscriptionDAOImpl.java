package gymApp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gymApp.model.Subscription;

public class SubscriptionDAOImpl implements SubscriptionDAO {

    private Connection connection;

    public SubscriptionDAOImpl(Connection connection) {
        this.connection = connection;
        try {
            createSubscriptionsTable();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createSubscriptionsTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS subscriptions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id INTEGER NOT NULL, " +
                "plan_name TEXT NOT NULL, " +
                "start_date DATE NOT NULL, " +
                "end_date DATE NOT NULL, " +
                "status TEXT NOT NULL, " +
                "FOREIGN KEY(user_id) REFERENCES users(id) " +
                ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    @Override
    public boolean save(Subscription subscription) {
        String query = "INSERT INTO subscriptions (user_id, plan_name, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, subscription.getUserId());
            stmt.setString(2, subscription.getPlanName());
            stmt.setDate(3, new java.sql.Date(subscription.getStartDate().getTime()));
            stmt.setDate(4, new java.sql.Date(subscription.getEndDate().getTime()));
            stmt.setString(5, subscription.getStatus());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    subscription.setId(generatedKeys.getInt(1)); 
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Subscription subscription) {
        String query = "UPDATE subscriptions SET plan_name = ?, start_date = ?, end_date = ?, status = ? " +
                "WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subscription.getPlanName());
            stmt.setDate(2, new Date(subscription.getStartDate().getTime()));
            stmt.setDate(3, new Date(subscription.getEndDate().getTime()));
            stmt.setString(4, subscription.getStatus());
            stmt.setInt(5, subscription.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int subscriptionId) {
        String query = "DELETE FROM subscriptions WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subscriptionId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Subscription findByUserId(int userId) {
        String query = "SELECT * FROM subscriptions WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Subscription(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("plan_name"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Subscription> findAll() {
        String query = "SELECT * FROM subscriptions";
        List<Subscription> subscriptions = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                subscriptions.add(new Subscription(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("plan_name"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }
}
