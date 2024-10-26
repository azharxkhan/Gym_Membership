package gymApp.model;

/**
 * Represents a nutrition plan associated with a workout plan.
 */
public class NutritionPlan {
    private int nutritionId;
    private int planId;
    private String mealName;
    private String description;
    private int calories;

    /**
     * Gets the unique identifier for this nutrition plan.
     *
     * @return the nutrition ID.
     */
    public int getNutritionId() {
        return nutritionId;
    }

    /**
     * Sets the unique identifier for this nutrition plan.
     *
     * @param nutritionId the new nutrition ID.
     */
    public void setNutritionId(int nutritionId) {
        this.nutritionId = nutritionId;
    }

    /**
     * Gets the ID of the associated workout plan.
     *
     * @return the plan ID.
     */
    public int getPlanId() {
        return planId;
    }

    /**
     * Sets the ID of the associated workout plan.
     *
     * @param planId the new plan ID.
     */
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    /**
     * Gets the name of the meal in the nutrition plan.
     *
     * @return the meal name.
     */
    public String getMealName() {
        return mealName;
    }

    /**
     * Sets the name of the meal in the nutrition plan.
     *
     * @param mealName the new meal name.
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * Gets the description of the meal in the nutrition plan.
     *
     * @return the description of the meal.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the meal in the nutrition plan.
     *
     * @param description the new description of the meal.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the caloric content of the meal in the nutrition plan.
     *
     * @return the number of calories.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Sets the caloric content of the meal in the nutrition plan.
     *
     * @param calories the new number of calories.
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }
}
