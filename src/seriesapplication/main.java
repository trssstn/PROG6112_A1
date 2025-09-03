package seriesapplication;

import java.util.*;

public class main {
    
    //Arraylist to store multiple series
    public static ArrayList<seriesModel> seriesList;
    
    //Constructor for the application
    public static void main() {
        seriesList = new ArrayList<>();
    }
    
    //Method for adding a series
    public static void addSeries(String id, String name, String age, String episodes) {
        seriesModel newSeries = new seriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
        System.out.println("Series processed succesfully!");
    }
    
    //Method for age and input validation
    public static String getValidAge(Scanner input) {
        String ageInput;
        int ageValue;
        
        while (true) {
            System.out.println("Enter the series age restriction: ");
            ageInput = input.nextLine().trim();
            
            //Checking if input is empty
            if (ageInput.isEmpty()) {
                System.out.println("Age cannot be empty! Please try again.");
                continue;
            }
            
            //Checking if input only contains numbers
            if (!ageInput.matches("\\d+")) {
                System.out.println("Only numbers are allowed! Please try again.");
                continue;
            }
            
            //Convert input to integer and validate age range
            try {
                ageValue = Integer.parseInt(ageInput);
                
                if (ageValue >= 2 && ageValue <= 18) {
                    return ageInput; //Valid age is returned as a string
                } else {
                    System.out.println("Age restriction must be between 2 and 18! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format! Please try again.");
            }   
        }
    }
    
    //Method to search for a series by ID
    public static void searchSeries(String searchID) {
        boolean found = false;
        
        for (seriesModel series : seriesList) {
            if (series.SeriesID.equalsIgnoreCase(searchID)) {
                System.out.println("\n----------------------------------------------");
                System.out.println("SERIES ID: " + series.SeriesID);
                System.out.println("SERIES NAME: " + series.SeriesName);
                System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
                System.out.println("----------------------------------------------");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series with series ID: " + searchID + " was not found!");
        }
    }
    
    //Method for updating a series
    public static void updateSeries(String updateID, Scanner input) {
        seriesModel seriesToUpdate = null;
        
        //Finding the series to be updated
        for (seriesModel series : seriesList) {
            if (series.SeriesID.equalsIgnoreCase(updateID)) {
                seriesToUpdate = series;
                break;
            }
        }
        
        if (seriesToUpdate == null) {
            System.out.println("No series found with series ID: " + updateID);
            return;
        }
        
        //Display current series details
        System.out.println("\n------------------------------------------");
        System.out.println("CURRENT SERIES DETAILS:");
        System.out.println("SERIES ID: " + seriesToUpdate.SeriesID);
        System.out.println("SERIES NAME: " + seriesToUpdate.SeriesName);
        System.out.println("SERIES AGE RESTRICTION: " + seriesToUpdate.SeriesAge);
        System.out.println("SERIES NUMBER OF EPISODES: " + seriesToUpdate.SeriesNumberOfEpisodes);
        System.out.println("------------------------------------------\n");
        
        //Update menu for user selection
        while (true) {
            System.out.println("What would you like to update?");
            System.out.println("(1) Series Name");
            System.out.println("(2) Age Restriction");
            System.out.println("(3) Number of Episodes");
            System.out.println("(4) Update All");
            System.out.println("(5) Done updating");
            System.out.println("Select an option:");
            
            int updateChoice = 0;
            try {
                updateChoice = input.nextInt();
                input.nextLine(); 
            } catch (Exception e) {
                input.nextLine(); //Clear invalid input
                System.out.println("Invalid input! Please try again.");
                continue;
            }
            
            switch (updateChoice) {
                case 1:
                    System.out.println("Enter new series name: ");
                    String newName = input.nextLine();
                    seriesToUpdate.SeriesName = newName;
                    System.out.println("Series name updated successfully!");
                    break;
                    
                case 2:
                    String newAge = getValidAge(input);
                    seriesToUpdate.SeriesAge = newAge;
                    System.out.println("Age restriction updated successfully!");
                    break;
                    
                case 3:
                    System.out.println("Enter new number of episodes: ");
                    String newEpisodes = input.nextLine();
                    seriesToUpdate.SeriesNumberOfEpisodes = newEpisodes;
                    System.out.println("Number of episodes updated successfully!");
                    break;
                    
                case 4:
                    System.out.println("Enter new series name: ");
                    seriesToUpdate.SeriesName = input.nextLine();
                    
                    seriesToUpdate.SeriesAge = getValidAge(input);
                    
                    System.out.println("Enter new number of episodes: ");
                    seriesToUpdate.SeriesNumberOfEpisodes = input.nextLine();
                    
                    System.out.println("All fields updated successfully!");
                    break;
                    
                case 5:
                    System.out.println("Closing updates...");
                    return;
                    
                default: 
                    System.out.println("Invalid option! Please select (1) - (5).");
            }
        }
    }
    
    //Method for deleting a series
    public static void deleteSeries(String deleteID, Scanner input) {
        seriesModel seriesToDelete = null;
        
        //Finding the series ID to delete
        for (seriesModel series : seriesList) {
            if (series.SeriesID.equalsIgnoreCase(deleteID)) {
                seriesToDelete = series;
                break;
            }
        }
        
        if (seriesToDelete == null) {
            System.out.println("No series with that series ID was found!");
            return;
        }
        
        //Confirming deletion 
        System.out.println("Are you sure you want to delete the series " + seriesToDelete.SeriesName + "? Yes (y) to delete, No (n) to cancel: ");
        String confirmation = input.nextLine().trim();
        
        if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
            seriesList.remove(seriesToDelete);
            System.out.println("Series with series ID " + seriesToDelete.SeriesID + " has been deleted successfully!");
        } else {
            System.out.println("Deletion cancelled - series was not deleted");
        }
    }
    
    //Method to display all series
    public void seriesReport(){
        
        if (seriesList.isEmpty()) {
            System.out.println("No series have been added!");
            return;
        }
        
        System.out.println("Placeholder code");
        for (seriesModel series : seriesList) {
            System.out.println(series);
        }
    }
    
    public static void main(String[] args) {
        
//----------------------------------MAIN CONSOLE RUNNING CODE-----------------------------------------------
        
        int choice;
        Scanner input = new Scanner(System.in);
        
        System.out.println("LATEST SERIES - 2025");
        System.out.println("***************************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        //If a non-number value is entered, the application closes
        if (!input.hasNextInt()) {
            System.out.println("Shutting down...");
            System.exit(0);
        }
        
        choice = input.nextInt();
        
        //If a number value other than 1 is entered, the application closes
        if (choice != 1) {
            System.out.println("Shutting down...");
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
                System.out.print("Oops! That's not a number, try again:\n");
                input.next(); //clears bad input
            }
            
            choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    //Menu generation for adding a new series
                    System.out.println("Enter the series ID: ");
                    String id = input.nextLine();
                    
                    System.out.println("Enter the series name: ");
                    String name = input.nextLine();
                    
                    //Only allowing validated age restriction to be saved to memory
                    String age = getValidAge(input);
                    
                    System.out.println("Enter the number of episodes for " + name + ": ");
                    String episodes = input.nextLine();
                    
                    addSeries(id, name, age, episodes);
                    System.out.println("Series has been succesfully added!");
                    break;
                    
                case 2:
                    //Menu generation for searching a series
                    System.out.println("Enter the series ID to search: ");
                    String searchID = input.nextLine().trim();
                    
                    if (searchID.isEmpty()) {
                        System.out.println("Series ID cannot be empty!");
                    } else {
                        searchSeries(searchID);
                    }
                    break;
                    
                case 3: 
                    //Menu generation for updating a series
                    System.out.println("Enter the series ID to update: ");
                    String updateID = input.nextLine().trim();
                    
                    if (updateID.isEmpty()) {
                        System.out.println("Series ID cannot be empty!");
                    } else {
                        updateSeries(updateID, input);
                    }
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
                    System.out.println("Sorry, that's not an option. Try again:\n");
            }
            
        } while (choice != 6); //main application do-while loop only stops when user enters 6 to exit application
        
    }
    
    public static void clearConsole() {
        //Code to give the impression of clearing the console
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    
}
