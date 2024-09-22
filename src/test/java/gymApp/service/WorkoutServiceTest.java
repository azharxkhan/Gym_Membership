package gymApp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gymApp.model.WorkoutPlan;

public class WorkoutServiceTest {
    private WorkoutService workoutService;
    private final String url = "jdbc:sqlite:gymdb.db";

    @BeforeEach
    public void setUp() {
        workoutService = new WorkoutService();
    }

    @AfterEach
    public void tearDown() {
        String sql = "DELETE FROM workout_plans";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Database cleaned up after test.");
        } catch (SQLException e) {
            System.err.println("Error during database cleanup.");
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateWorkoutPlan() {
        WorkoutPlan plan = new WorkoutPlan("Full Body", "Strength", "Beginner", "Admin");
        WorkoutPlan createdPlan = workoutService.createWorkoutPlan(plan);
        assertNotNull(createdPlan);
        assertEquals("Full Body", createdPlan.getName());
    }

    @Test
    public void testGetAllWorkoutPlans() {
        WorkoutPlan plan = new WorkoutPlan("Cardio Burn", "Weight Loss", "Intermediate", "Coach");
        workoutService.createWorkoutPlan(plan);

        List<WorkoutPlan> plans = workoutService.getAllWorkoutPlans();
        assertNotNull(plans);
        assertFalse(plans.isEmpty());
    }
}
