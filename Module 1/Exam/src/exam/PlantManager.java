/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//AS2019503 GBC PRABHASHWARA
package exam;
import java.util.*;
/**
 *
 * @author CHAMOD
 */
public class PlantManager {

    private Scanner sc = new Scanner(System.in);
    private InputValidator input = new InputValidator();
    private DataController dataController = new DataController();
    private Common common = new Common();
    private List<Batch> batchList = new ArrayList<Batch>();

    //Main
    public static void main(String[] args) {
        System.out.println("***     Hello welcome to our plan manager tool!   ***");
        PlantManager planManger = new PlantManager();
        planManger.displayMenu();   //Calling mainmenu
    }

    public void displayMenu(){
        batchList = dataController.importData();
        System.out.print("\t1. Enter batch of plants,\n\t2. View Plant Details,\n\t3. View all the crops,\n\t4. Add crop harvest,\n\t5. Check for the maximum crops status ,\n\nPlease enter your option to continue: ");
        int userInput = sc.nextInt();
         switch (userInput){
             case 1:
                 addBatch();
                 break;
             case 2:
                 selectBatchCode(2);
                 break;
             case 3:
                 selectBatchCode(3);
                 break;
             case 4:
                 selectBatchCode(4);
                 break;
             case 5:
                 selectBatchCode(5);
                 break;
             default:
                 System.err.println("Please enter valid input and try again,");
                 displayMenu();
         }
    }

    //Show all batch details and give an option to select batch
    public void selectBatchCode(int type){
        int index = 1;
        //Printing Batch details
        for(Batch batch: batchList){
            System.out.println("\t" +(index++) + ") Batch Number: "+ batch.getBatchNumber() + "\n\t- Date of planted: "+batch.getDateOfPlanted());
        }

        //Getting the users choise
        int userInputIndex = 0;
        do{
            userInputIndex = input.getInt("Please enter your required batch number,");
        } while (batchList.size() < userInputIndex || userInputIndex <= 0);
        showThePlants(userInputIndex - 1, type);
    }

    public void showThePlants(int batchIndex, int type){
        List<Plants> plantListTemp = batchList.get(batchIndex).getPlantsList();

        int index = 1;
        for(Plants plants: plantListTemp){
            System.out.println((index++) + ") Plant name: "+ plants.getPlantName());
        }
        int userInputIndex = 0;
        do{
            userInputIndex = input.getInt("Please enter your required plant id,");
        } while (batchList.size() < userInputIndex || userInputIndex <= 0);

        if(type == 2){
            showSinglePlantDetails(plantListTemp.get(userInputIndex - 1));
        } else if(type == 3){
            System.out.println(plantListTemp.get(userInputIndex - 1).getCropHarvest().toString());
        }  else if(type == 4){
            addHarvestToArray(batchIndex, userInputIndex - 1);
        }  else if(type == 5){
            isMaximumCropsReached(batchIndex, userInputIndex - 1);
        }
        common.displayEndingMenu();
    }

    public void addHarvestToArray(int batchIndex, int plantIndex){
        System.out.println(batchList.get(batchIndex));
        Batch batchObj = batchList.get(batchIndex);

        Plants plant = batchObj.getPlantsList().get(plantIndex);
        List <Harvest> currentCropHarvest = plant.getCropHarvest();
        currentCropHarvest.add(getHarvest());
        plant.setCropHarvest(currentCropHarvest);
        List<Plants> plantList = batchList.get(batchIndex).getPlantsList();
        plantList.set(plantIndex, plant);

        Batch batchTemp = batchList.get(batchIndex);
        batchTemp.setPlantsList(plantList);
        batchList.set(batchIndex, batchTemp);
        dataController.saveData(batchList);
        common.displayEndingMenu();
    }

    //Method to find whether maximum crops are reached
    public void isMaximumCropsReached(int batchIndex, int plantIndex) {
        Batch batchObj = batchList.get(batchIndex);
        Plants plant = batchObj.getPlantsList().get(plantIndex);
        int maxCropReach = plant.getLifeTime() / plant.getCoppingInterval();
        System.out.println("Maximum reach that can get the crop: "+maxCropReach);
        System.out.println("Crops for now: "+plant.getCropHarvest().size());
        System.out.println(maxCropReach <= plant.getCropHarvest().size() ? "Plant has reached to the maximum crop size.": "Plant has not reached to the maximum crop size.");
    }

    //Printing single plant details of a batch
    public void showSinglePlantDetails(Plants plant){
        System.out.println(plant.toString());
        System.out.println("\tPlant Name : "+ plant.getPlantName());
        System.out.println("\tGrowing Duration : "+ plant.getGrowingDuration());
        System.out.println("\tCropping Duration : "+ plant.getCoppingInterval());
        System.out.println("\tLife Time : "+ plant.getLifeTime());
        System.out.println("\tCrop Harvest : "+ plant.getCropHarvest());

        //Printing personal objects of fruits and vegetables
        if(plant instanceof Fruit){
            System.out.println("\tStandard volume: "+((Fruit) plant).getStandardVolume());
            System.out.println("\tStandard Average color: "+((Fruit) plant).getStandardAverageColor());
            System.out.println("\tStandard PH: "+((Fruit) plant).getStandardPH());
        } else {
            System.out.println("\tStandard area per leaf: "+((Vegetable) plant).getStandardAreaPerLeaf());
            System.out.println("\tStandard thickness: "+((Vegetable) plant).getStandardThickness());
        }
        common.displayEndingMenu();
    }

    //Adding a new batch
    public void addBatch() {
        Batch tempBatch = new Batch();
        //tempBatch.setBatchNumber(input.getInt("\tPlease enter batch number :"));
        tempBatch.setDateOfPlanted(input.getDate("\tPlease enter planted date :"));
        tempBatch.setPlantsList(addPlants());
        tempBatch.setEndOfBatch(tempBatch.getDateOfPlanted().plusDays(getEndOfBatch(tempBatch.getPlantsList())));//Adding maximum life span days to the planted date 
        batchList.add(tempBatch);
        dataController.saveData(batchList);
        common.displayEndingMenu();
    }

    //Finding which plant has the maximum life span
    private int getEndOfBatch(List<Plants> plantsList){
        int maxLifeTime = 0;
        for(Plants plantObj: plantsList){
            if(plantObj.getLifeTime() > maxLifeTime){
                maxLifeTime = plantObj.getLifeTime();
            }
        }
        return maxLifeTime;
    }

    public List<Plants> addPlants() {
        List<Plants> tempPlantList = new ArrayList<Plants>();
        System.out.println("\nLets enter plants in the batch!");
        boolean continueToEnterPlants = true;

        while(continueToEnterPlants){
            System.out.println("\t1. Fruit plant, \n\t2. Vegetable plant,\n\t3. Exit\n\n");

            switch (input.getInt("Enter option to continue...")){
                case 1:
                    tempPlantList.add((Plants) getFruitObj());
                    break;
                case 2:
                    tempPlantList.add(getVegetableObj());
                    break;
                case 3:
                    continueToEnterPlants = false;
                    break;
                default:
                    System.out.println("Please enter valid valid input and try again!");
            }
        }

        return tempPlantList;
    }

    public Plants getFruitObj(){
        Fruit fruit = new Fruit();
        fruit.setPlantName(input.getString("\tPlease enter the plant name :"));
        fruit.setGrowingDuration(input.getInt("\tEnter the growing duration :"));
        fruit.setCoppingInterval(input.getInt("\tEnter cropping interval :"));
        fruit.setLifeTime(input.getInt("\tEnter Lifetime :"));
        fruit.setStandardVolume(input.getDouble("\tPlease enter standard volume :"));
        fruit.setStandardAverageColor(input.getInt("\tEnter Average Color :"));
        fruit.setStandardPH(input.getInt("Enter Standard PH (0-14):"));
        fruit.setCropHarvest(getHarvestList());
        return fruit;
    }

    public Plants getVegetableObj(){
        Vegetable vegetable = new Vegetable();
        vegetable.setPlantName(input.getString("\tPlease enter the plant name :"));
        vegetable.setGrowingDuration(input.getInt("\tEnter the growing duration :"));
        vegetable.setCoppingInterval(input.getInt("\tEnter cropping interval :"));
        vegetable.setLifeTime(input.getInt("\tEnter Lifetime :"));
        vegetable.setStandardAreaPerLeaf(input.getDouble("\tEnter Standard Area per leaf :"));
        vegetable.setStandardThickness(input.getDouble("\tEnter the standard thikness :"));
        vegetable.setCropHarvest(getHarvestList());
        return vegetable;
    }

    public List<Harvest> getHarvestList(){
        List<Harvest> harvestList = new ArrayList<Harvest>();
        System.out.println("Are you ready to add harvest to previously entered plant ?");
        boolean continueToEnterPlants = true;

        while(continueToEnterPlants){
            System.out.println("\t1. Add Harvest,\n\t2. Exit\n\n");
            switch (input.getInt("Enter to continue,")){
                case 1:
                    harvestList.add(getHarvest());
                    break;
                case 2:
                    continueToEnterPlants = false;
                    break;
                default:
                    System.out.println("Please enter valid valid input and try again!");
            }
        }
        return harvestList;
    }

    public Harvest getHarvest(){
        Harvest harvest = new Harvest();
        harvest.setDate(input.getDate("\tPlease enter harvest date!"));
        harvest.setTotalWeight(input.getDouble("\tEnter the total weight"));
        harvest.setState(State.values()[input.getState("\tSet the state (0-standard  1-below standar 2-above standard)")]);
        return harvest;
    }
}
