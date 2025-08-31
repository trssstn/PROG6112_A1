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
        
        if (!input.hasNextInt()) {
            System.exit(0);
        }
        
        choice = input.nextInt();
        
        if (choice != 1) {
            System.exit(0);
        }
        
        
        
        do {
            System.out.println();
        } while (choice != 4);
        
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
