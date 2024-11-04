package gymApp.service;

import gymApp.model.FitnessGoal;
import java.time.LocalDate;

public class FitnessGoalService {

    public FitnessGoal createGoal(int id, String description, LocalDate startDate, LocalDate targetDate) {
        FitnessGoal newGoal = new FitnessGoal(id, description);
        newGoal.setStartDate(startDate);
        newGoal.setTargetDate(targetDate);
        System.out.println("New fitness goal created: " + newGoal.getGoalDescription());
        return newGoal;
    }
}
