/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//AS2019503 GBC PRABHASHWARA
package exam;

/**
 *
 * @author CHAMOD
 */
import java.io.Serializable;
import java.time.LocalDate;

public class Harvest implements Serializable {
    private LocalDate date;
    private Double totalWeight;
    private State state;

    public Harvest() {
    }
    public Harvest(LocalDate date, Double totalWeight, State state) {
        this.date = date;
        this.totalWeight = totalWeight;
        this.state = state;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Harvest{" +
                "date=" + date +
                ", totalWeight=" + totalWeight +
                ", state='" + state + '\'' +
                '}';
    }
}