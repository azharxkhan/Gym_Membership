    package gymApp.dao;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;

    import gymApp.model.WorkoutPlan;

    public class WorkoutPlanDAOImpl implements WorkoutPlanDAO {
        private final String url = "jdbc:sqlite:gymdb.db";

        public WorkoutPlanDAOImpl() {
            createTableIfNotExists();
        }

        private void createTableIfNotExists() {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS workout_plans (" +
                    "plan_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "goal TEXT NOT NULL, " +
                    "level TEXT NOT NULL, " +
                    "created_by TEXT NOT NULL" +
                    ");";

            try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Workout plans table is ready.");
            } catch (SQLException e) {
                System.err.println("Failed to create workout_plans table.");
                e.printStackTrace();
            }
        }

        @Override
        public WorkoutPlan createWorkoutPlan(WorkoutPlan plan) {
            String sql = "INSERT INTO workout_plans(name, goal, level, created_by) VALUES(?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setString(1, plan.getName());
                pstmt.setString(2, plan.getGoal());
                pstmt.setString(3, plan.getLevel());
                pstmt.setString(4, plan.getCreatedBy());
                pstmt.executeUpdate();

                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.next()) {
                    plan.setPlanId(keys.getInt(1));
                }
                return plan;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public List<WorkoutPlan> getAllWorkoutPlans() {
            List<WorkoutPlan> plans = new ArrayList<>();
            String sql = "SELECT * FROM workout_plans";

            try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    WorkoutPlan plan = new WorkoutPlan(
                            rs.getInt("plan_id"),
                            rs.getString("name"),
                            rs.getString("goal"),
                            rs.getString("level"),
                            rs.getString("created_by")
                    );
                    plans.add(plan);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return plans;
        }

        @Override
        public boolean updateWorkoutPlan(WorkoutPlan plan) {
            String sql = "UPDATE workout_plans SET name = ?, goal = ?, level = ?, created_by = ? WHERE plan_id = ?";

            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, plan.getName());
                pstmt.setString(2, plan.getGoal());
                pstmt.setString(3, plan.getLevel());
                pstmt.setString(4, plan.getCreatedBy());
                pstmt.setInt(5, plan.getPlanId());
                int affectedRows = pstmt.executeUpdate();
                return affectedRows > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        public boolean deleteWorkoutPlan(int planId) {
            String sql = "DELETE FROM workout_plans WHERE plan_id = ?";

            try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, planId);
                int affectedRows = pstmt.executeUpdate();
                return affectedRows > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
    public WorkoutPlan findWorkoutPlanById(int planId) {
        String sql = "SELECT * FROM workout_plans WHERE plan_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, planId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                WorkoutPlan plan = new WorkoutPlan(
                        rs.getInt("plan_id"),
                        rs.getString("name"),
                        rs.getString("goal"),
                        rs.getString("level"),
                        rs.getString("created_by")
                );
                return plan;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
