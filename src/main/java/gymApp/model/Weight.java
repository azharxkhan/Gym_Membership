package gymApp.model;

import java.time.LocalDate;

/**
 * Represents the weight of an individual, recorded on a specific date.
 */
public class Weight {
    private int id;
    private LocalDate date;
    private double weight;

    /**
     * Gets the unique identifier for this weight entry.
     *
     * @return the ID of the weight entry.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this weight entry.
     *
     * @param id the new ID of the weight entry.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the date when the weight was recorded.
     *
     * @return the date of the weight entry.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date when the weight was recorded.
     *
     * @param date the date of the weight entry.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the weight value.
     *
     * @return the weight in kilograms.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight value.
     *
     * @param weight the weight in kilograms.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
