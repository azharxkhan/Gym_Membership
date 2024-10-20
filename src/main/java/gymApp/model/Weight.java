package gymApp.model;

import java.time.LocalDate;

public class Weight {
    private int id;
    private LocalDate date;
    private double weight; // in kg (bc most of world is kg)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}

