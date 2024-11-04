package gymApp.model;

/**
 * Represents the progress tracking of a member's exercise activities.
 */
public class ProgressTracking {
    private int progressId;
    private int memberId;
    private String date;
    private int exerciseId;
    private int setsCompleted;
    private int repsCompleted;
    private String notes;

    /**
     * Gets the unique identifier for this progress tracking entry.
     *
     * @return the progress ID.
     */
    public int getProgressId() {
        return progressId;
    }

    /**
     * Sets the unique identifier for this progress tracking entry.
     *
     * @param progressId the new progress ID.
     */
    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    /**
     * Method to update the related FitnessGoal with new progress.
     * @param fitnessGoal The fitness goal to update.
     * @param progressIncrement The increment in progress.
     */
    public void updateGoalProgress(FitnessGoal fitnessGoal, double progressIncrement) {
        double currentProgress = fitnessGoal.getProgressPercentage();
        double updatedProgress = currentProgress + progressIncrement;
        fitnessGoal.updateProgress(updatedProgress);
    }

    /**
     * Gets the ID of the member associated with this progress tracking entry.
     *
     * @return the member ID.
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the ID of the member associated with this progress tracking entry.
     *
     * @param memberId the new member ID.
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * Gets the date when the progress was recorded.
     *
     * @return the date of progress tracking.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date when the progress was recorded.
     *
     * @param date the date of progress tracking.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the ID of the exercise associated with this progress tracking entry.
     *
     * @return the exercise ID.
     */
    public int getExerciseId() {
        return exerciseId;
    }

    /**
     * Sets the ID of the exercise associated with this progress tracking entry.
     *
     * @param exerciseId the new exercise ID.
     */
    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    /**
     * Gets the number of sets completed for the exercise.
     *
     * @return the number of sets completed.
     */
    public int getSetsCompleted() {
        return setsCompleted;
    }

    /**
     * Sets the number of sets completed for the exercise.
     *
     * @param setsCompleted the new number of sets completed.
     */
    public void setSetsCompleted(int setsCompleted) {
        this.setsCompleted = setsCompleted;
    }

    /**
     * Gets the number of repetitions completed for the exercise.
     *
     * @return the number of repetitions completed.
     */
    public int getRepsCompleted() {
        return repsCompleted;
    }

    /**
     * Sets the number of repetitions completed for the exercise.
     *
     * @param repsCompleted the new number of repetitions completed.
     */
    public void setRepsCompleted(int repsCompleted) {
        this.repsCompleted = repsCompleted;
    }

    /**
     * Gets any additional notes associated with this progress tracking entry.
     *
     * @return the notes.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets any additional notes associated with this progress tracking entry.
     *
     * @param notes the new notes.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
