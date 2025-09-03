package seriesapplication;

import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        //Scanner for initial input
        Scanner scanner = new Scanner(System.in);
        
        //Displaying welcome menu
        System.out.println("LATEST SERIES - 2025");
        System.out.println("***************************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        //Getting user input
        String input = scanner.nextLine().trim();
        
        //Checking if user wishes to continue
        if (!input.equals("1")) {
            System.out.println("\nExiting application...");
            scanner.close();
            System.exit(0);
        }
        
        //Creating an instance of the Series class
        Series seriesManager = new Series();
        
        //Main menu loop
        while (true) {
            
            int choice = seriesManager.displayMenu();
            
            switch (choice) {
                case 1:
                    seriesManager.CaptureSeries();
                    break;
                    
                case 2:
                    seriesManager.SearchSeries();
                    break;
                    
                case 3: 
                    seriesManager.UpdateSeries();
                    break;
                    
                case 4:
                    seriesManager.DeleteSeries();
                    break;
                    
                case 5:
                    seriesManager.SeriesReport();
                    break;
                    
                case 6:
                    seriesManager.ExitSeriesApplication();
                    break;
                    
                default:
                    if (choice != 0) {
                       System.out.println("Sorry, that's not an option. Try again:\n"); 
                    }      
            }   
        }   
    }    
}
