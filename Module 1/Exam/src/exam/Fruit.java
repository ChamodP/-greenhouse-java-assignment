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
public class Fruit extends Plants implements Serializable {

    private Double standardVolume;
    private int standardAverageColor;
    private int standardPH;

    //parameterless constructer
    public Fruit() {
    }

    //parameter constructor
    public Fruit(Double standardVolume, int standardAverageColor, int standardPH) {
        super();
        this.standardVolume = standardVolume;
        this.standardAverageColor = standardAverageColor;
        this.standardPH = standardPH;
    }

    //getters setters
    public Double getStandardVolume() {
        return standardVolume;
    }

    public void setStandardVolume(Double standardVolume) {
        this.standardVolume = standardVolume;
    }

    public int getStandardAverageColor() {
        return standardAverageColor;
    }

    public void setStandardAverageColor(int standardAverageColor) {
        this.standardAverageColor = standardAverageColor;
    }

    public int getStandardPH() {
        return standardPH;
    }

    public void setStandardPH(int standardPH) {
        if(standardPH>0 && standardPH<15){
            this.standardPH = standardPH;
        }
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "standardVolume=" + standardVolume
                + ", standardAverageColor=" + standardAverageColor
                + ", standardPH=" + standardPH
                + '}';
    }
}