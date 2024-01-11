/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//AS2019503
package module.pkg2;

/**
 *
 * @author CHAMOD
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sensor tempSensor = new Sensor(SensorTypes.TEMPERATURE);
        Sensor humidSensor = new Sensor(SensorTypes.HUMIDITY);
        Sensor phSensor = new Sensor(SensorTypes.PH);
        
    }
    
}
