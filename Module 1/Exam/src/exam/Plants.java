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
import java.util.List;


//Mechannism of writing state of an object into a byte-stream is serialization
//objects can be converted into byte-stream
//To make it allow to save object
public abstract class Plants implements Serializable {
    private String plantName;
    private int growingDuration;
    private int coppingInterval;
    private int lifeTime;
    private List<Harvest> cropHarvest;

   //parameterless constructer
    public Plants() { }

    //getters and setters
    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getGrowingDuration() {
        return growingDuration;
    }

    public void setGrowingDuration(int growingDuration) {
        this.growingDuration = growingDuration;
    }

    public int getCoppingInterval() {
        return coppingInterval;
    }

    public void setCoppingInterval(int coppingInterval) {
        this.coppingInterval = coppingInterval;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public List<Harvest> getCropHarvest() {
        return cropHarvest;
    }

    public void setCropHarvest(List<Harvest> cropHarvest) {
        this.cropHarvest = cropHarvest;
    }

    @Override
    public String toString() {
        return "Plants{" +
                "plantName='" + plantName + '\'' +
                ", growingDuration=" + growingDuration +
                ", coppingInterval=" + coppingInterval +
                ", lifeTime=" + lifeTime +
                ", cropHarvest=" + cropHarvest +
                '}';
    }
}