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
import java.util.List;

public class Batch implements Serializable {
    public static int batchNoGenerator = 0;
    private int batchNumber;
    private List<Plants> plantsList;
    private LocalDate dateOfPlanted;
    private LocalDate endOfBatch;

    public Batch() {
        batchNoGenerator++; //to auto generate the batch number
        batchNumber = batchNoGenerator;
    }


    public Batch(List<Plants> plantsList, LocalDate dateOfPlanted, LocalDate endOfBatch) {
        batchNoGenerator++;//to auto generate the batch number
        batchNumber = batchNoGenerator;
        this.plantsList = plantsList;
        this.dateOfPlanted = dateOfPlanted;
        this.endOfBatch = endOfBatch;
    }

    public int getBatchNumber() {
        return batchNumber;
    }


    public List<Plants> getPlantsList() {
        return plantsList;
    }

    public void setPlantsList(List<Plants> plantsList) {
        this.plantsList = plantsList;
    }

    public LocalDate getDateOfPlanted() {
        return dateOfPlanted;
    }

    public void setDateOfPlanted(LocalDate dateOfPlanted) {
        this.dateOfPlanted = dateOfPlanted;
    }

    public LocalDate getEndOfBatch() {
        return endOfBatch;
    }

    public void setEndOfBatch(LocalDate endOfBatch) {
        this.endOfBatch = endOfBatch;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchNumber=" + batchNumber +
                ", plantsList=" + plantsList.toString() +
                ", dateOfPlanted=" + dateOfPlanted +
                ", endOfBatch=" + endOfBatch +
                '}';
    }
}