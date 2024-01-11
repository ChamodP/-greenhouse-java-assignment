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
public interface SensorListener {
    
    public void onValueUpdated(SensorTypes Type, double value);
    
}
