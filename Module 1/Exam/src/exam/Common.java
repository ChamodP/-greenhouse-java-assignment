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
public class Common {

    private InputValidator input = new InputValidator();

    public void displayEndingMenu(){
        System.out.println("1. Continue to main menu,\n2. Exit from the application,\n");
        switch (input.getInt("Please enter to continue,")){
            case 1:
                PlantManager plantManagerObj = new PlantManager();
                plantManagerObj.displayMenu();
            case 2:
                System.out.println("Thank you, come back again!");
                System.exit(0);
            default:
                displayEndingMenu();
        }
    }
}
