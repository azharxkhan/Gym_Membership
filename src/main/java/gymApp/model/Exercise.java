package gymApp.model;

/**
 * Represents an exercise within a workout plan.
 */
public class Exercise {
    private int exerciseId;
    private int planId;
    private String name;
    private int sets;
    private int reps;
    private int restTime;

    /**
     * Gets the unique identifier for this exercise.
     *
     * @return the exercise ID.
     */
    public int getExerciseId() {
        return exerciseId;
    }

    /**
     * Sets the unique identifier for this exercise.
     *
     * @param exerciseId the new exercise ID.
     */
    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    /**
     * Gets the ID of the workout plan to which this exercise belongs.
     *
     * @return the plan ID.
     */
    public int getPlanId() {
        return planId;
    }

    /**
     * Sets the ID of the workout plan to which this exercise belongs.
     *
     * @param planId the new plan ID.
     */
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    /**
     * Gets the name of the exercise.
     *
     * @return the name of the exercise.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the exercise.
     *
     * @param name the new name of the exercise.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the number of sets for this exercise.
     *
     * @return the number of sets.
     */
    public int getSets() {
        return sets;
    }

    /**
     * Sets the number of sets for this exercise.
     *
     * @param sets the new number of sets.
     */
    public void setSets(int sets) {
        this.sets = sets;
    }

    /**
     * Gets the number of repetitions per set for this exercise.
     *
     * @return the number of repetitions.
     */
    public int getReps() {
        return reps;
    }

    /**
     * Sets the number of repetitions per set for this exercise.
     *
     * @param reps the new number of repetitions.
     */
    public void setReps(int reps) {
        this.reps = reps;
    }

    /**
     * Gets the rest time between sets for this exercise.
     *
     * @return the rest time in seconds.
     */
    public int getRestTime() {
        return restTime;
    }

    /**
     * Sets the rest time between sets for this exercise.
     *
     * @param restTime the new rest time in seconds.
     */
    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }
}
