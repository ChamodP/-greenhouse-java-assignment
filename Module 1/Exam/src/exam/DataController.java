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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataController {
    //save data to the file
    public void saveData(List<Batch> dataArray){
        try{
            FileOutputStream fos= new FileOutputStream("data");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(dataArray);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    //get data from the file
    public List<Batch> importData(){
        List<Batch> batchList = new ArrayList<Batch>();
        try
        {
            FileInputStream fis = new FileInputStream("data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            batchList = (List<Batch>) ois.readObject();
            ois.close();
            fis.close();
            return batchList;
        }catch(Exception e){
            System.out.println("Data file is not found!");
            return new ArrayList<Batch>();
        }
    }
}