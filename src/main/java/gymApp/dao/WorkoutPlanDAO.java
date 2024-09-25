package gymApp.dao;

import java.util.List;

import gymApp.model.WorkoutPlan;

/**
 * Data Access Object (DAO) interface for WorkoutPlan entities.
 */
public interface WorkoutPlanDAO {

    /**
     * Creates a new workout plan.
     * 
     * @param plan the workout plan to be created
     * @return the created workout plan
     */
    WorkoutPlan createWorkoutPlan(WorkoutPlan plan);

    /**
     * Retrieves all workout plans.
     * 
     * @return a list of all workout plans
     */
    List<WorkoutPlan> getAllWorkoutPlans();

    /**
     * Updates an existing workout plan.
     * 
     * @param plan the workout plan to be updated
     * @return true if the update is successful, false otherwise
     */
    boolean updateWorkoutPlan(WorkoutPlan plan);

    /**
     * Deletes a workout plan by its ID.
     * 
     * @param planId the ID of the workout plan to be deleted
     * @return true if the deletion is successful, false otherwise
     */
    boolean deleteWorkoutPlan(int planId);

    /**
     * Finds a workout plan by its ID.
     * 
     * @param planId the ID of the workout plan to be found
     * @return the workout plan with the given ID, or null if not found
     */
    WorkoutPlan findWorkoutPlanById(int planId);
}