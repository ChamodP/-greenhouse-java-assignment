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

//serialization is used to convert object to stream of bytes
public class Vegetable extends Plants implements Serializable {
    private Double standardAreaPerLeaf;
    private Double standardThickness;

    //parameterless constructer
    public Vegetable() {
    }

    //parameter constructor
    public Vegetable(Double standardAreaPerLeaf, Double standardThickness) {
        super();
        this.standardAreaPerLeaf = standardAreaPerLeaf;
        this.standardThickness = standardThickness;
    }

    //getters and setters
    public Double getStandardAreaPerLeaf() {
        return standardAreaPerLeaf;
    }

    public void setStandardAreaPerLeaf(Double standardAreaPerLeaf) {
        this.standardAreaPerLeaf = standardAreaPerLeaf;
    }

    public Double getStandardThickness() {
        return standardThickness;
    }

    public void setStandardThickness(Double standardThickness) {
        this.standardThickness = standardThickness;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "standardAreaPerLeaf=" + standardAreaPerLeaf +
                ", standardThickness=" + standardThickness +
                '}';
    }
}