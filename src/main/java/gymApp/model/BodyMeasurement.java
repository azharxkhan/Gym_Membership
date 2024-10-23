package gymApp.model;

import java.time.LocalDate;

/**
 * Represents the body measurements of an individual, recorded in centimeters.
 */
public class BodyMeasurement {
    private int id; 
    private LocalDate date;
    private double height; 
    private double chest; 
    private double waist; 
    private double hips; 

    /**
     * Gets the unique identifier for this body measurement.
     *
     * @return the ID of the body measurement.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this body measurement.
     *
     * @param id the new ID of the body measurement.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the date when the measurement was taken.
     *
     * @return the date of the measurement.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date when the measurement was taken.
     *
     * @param date the date of the measurement.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the height of the individual.
     *
     * @return the height in centimeters.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the individual.
     *
     * @param height the height in centimeters.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the chest circumference of the individual.
     *
     * @return the chest circumference in centimeters.
     */
    public double getChest() {
        return chest;
    }

    /**
     * Sets the chest circumference of the individual.
     *
     * @param chest the chest circumference in centimeters.
     */
    public void setChest(double chest) {
        this.chest = chest;
    }

    /**
     * Gets the waist circumference of the individual.
     *
     * @return the waist circumference in centimeters.
     */
    public double getWaist() {
        return waist;
    }

    /**
     * Sets the waist circumference of the individual.
     *
     * @param waist the waist circumference in centimeters.
     */
    public void setWaist(double waist) {
        this.waist = waist;
    }

    /**
     * Gets the hips circumference of the individual.
     *
     * @return the hips circumference in centimeters.
     */
    public double getHips() {
        return hips;
    }

    /**
     * Sets the hips circumference of the individual.
     *
     * @param hips the hips circumference in centimeters.
     */
    public void setHips(double hips) {
        this.hips = hips;
    }
}
