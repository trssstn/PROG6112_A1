package seriesapplication;

import java.util.*;

public class main {

    
    public static void main(String[] args) {
        
//----------------------------------MAIN CONSOLE RUNNING CODE-----------------------------------------------
        
        int choice;
        Scanner input = new Scanner(System.in);
        
        System.out.println("LATEST SERIES - 2025");
        System.out.println("***************************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        //If a non-number value is entered, the application closes
        if (!input.hasNextInt()) {
            System.exit(0);
        }
        
        choice = input.nextInt();
        
        //If a number value other than 1 is entered, the application closes
        if (choice != 1) {
            System.exit(0);
        }
        
        //The console is cleared to prepare for the main menu to be loaded
        clearConsole();
        
        //Main menu loop
        do {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit application");
            
            //Input validation to make sure the entered value is an integer
            while (!input.hasNextInt()) {
                System.out.print("Oops! That's not a number, try again:");
                input.next(); //clears bad input
            }
            
            choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    //enter logic here
                    break;
                case 2:
                    //enter logic here
                    break;
                case 3: 
                    //enter logic here
                    break;
                case 4:
                    //enter logic here
                    break;
                case 5:
                    //enter logic here
                    break;
                case 6:
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Sorry, that's not an option. Try again:");
            }
            
        } while (choice != 6); //main application do-while loop only stops when user enters 6 to exit application
        
    }
    
    public static void clearConsole() {
        //Code obtained from StackOverflow to clear the console
        
        //\033[H : Moves cursor to home position (top-left corner)
        //\033[2J : Clears the entire screen
        System.out.print("\033[H\033[2J");
        
        //Ensures output is immediately written to console
        System.out.flush();
    }
    
}
