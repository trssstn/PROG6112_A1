package seriesapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList;
    private Scanner scanner;
    
    //CONSTRUCTOR
    public Series() {
        seriesList = new ArrayList<>();
        scanner = new Scanner(System.in);
}

//Method for adding a new series
public void CaptureSeries() {
        System.out.println("Enter the series ID: ");
        String id = scanner.nextLine().trim();
        
        if (id.isEmpty()) {
            System.out.println("Series ID cannot be empty!");
            return;
        }
        
        System.out.println("Enter series name: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("Series name cannot be empty!");
            return;
        }
        
        String age = getValidAge();
        
        System.out.println("Enter number of episodes: ");
        String episodes = scanner.nextLine().trim();
        
        if (episodes.isEmpty()) {
            System.out.println("Number of episodes cannot be empty!");
            return;
        }
        
        SeriesModel newSeries = new SeriesModel (id, name, age, episodes);
        seriesList.add(newSeries);
        System.out.println("Series has been added successfully!");
    }   

    //Method for searching a series by its ID
    public void SearchSeries() {
        System.out.println("Enter series ID to search: ");
        String searchID = scanner.nextLine().trim();
        
        if (searchID.isEmpty()) {
            System.out.println("Search ID cannot be empty!");
            return;
        }
        
        boolean found = false;
        
        for (SeriesModel series : seriesList) {
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
            System.out.println("No series with the series ID " + searchID + " could be found!");
        }
    }

    //Method for updating a series
    public void UpdateSeries() {
        System.out.println("Enter series ID to update: ");
        String updateID = scanner.nextLine().trim();
        
        if (updateID.isEmpty()) {
            System.out.println("Series ID cannot be empty!");
            return;
        }
        
        SeriesModel seriesToUpdate = null;
        
        //Finding the series to be updated
        for (SeriesModel series : seriesList) {
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
            
            String updateChoiceStr = scanner.nextLine().trim();
            
            if (updateChoiceStr.isEmpty()) {
                continue;
            }
            
            int updateChoice;
            
            try {
                updateChoice = Integer.parseInt(updateChoiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please try again.");
                continue;
            }
            
            switch (updateChoice) {
                case 1:
                    System.out.println("Enter new series name: ");
                    String newName = scanner.nextLine();
                    seriesToUpdate.SeriesName = newName;
                    System.out.println("Series name updated successfully!");
                    break;
                    
                case 2:
                    String newAge = getValidAge();
                    seriesToUpdate.SeriesAge = newAge;
                    System.out.println("Age restriction updated successfully!");
                    break;
                    
                case 3:
                    System.out.println("Enter new number of episodes: ");
                    String newEpisodes = scanner.nextLine();
                    seriesToUpdate.SeriesNumberOfEpisodes = newEpisodes;
                    System.out.println("Number of episodes updated successfully!");
                    break;
                    
                case 4:
                    System.out.println("Enter new series name: ");
                    seriesToUpdate.SeriesName = scanner.nextLine();
                    
                    seriesToUpdate.SeriesAge = getValidAge();
                    
                    System.out.println("Enter new number of episodes: ");
                    seriesToUpdate.SeriesNumberOfEpisodes = scanner.nextLine();
                    
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
    
    //Method for series deletion
    public void DeleteSeries() {
        System.out.println("Enter series ID to delete: ");
        String deleteID = scanner.nextLine().trim();
        
        if (deleteID.isEmpty()) {
            System.out.println("Series ID cannot be empty!");
            return;
        }
        
        SeriesModel seriesToDelete = null;
        
        for (SeriesModel series : seriesList) {
            if (series.SeriesID.equalsIgnoreCase(deleteID)) {
                seriesToDelete = series;
                break;
            }
        }
        
        if (seriesToDelete == null) {
            System.out.println("No series with ID " + deleteID + " could be found!");
            return;
        }
        
        System.out.println("Are you sure you want to delete this series? (y/n)");
        String confirmation = scanner.nextLine().trim();
        
        if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
            seriesList.remove(seriesToDelete);
            System.out.println(" Series was deleted successfully!");
        } else {
            System.out.println("Deletion operation cancelled.");
        }
    }
    
    //Method for displaying series report
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series in database.");
            return;
        }
        
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel series = seriesList.get(i);
            System.out.println("Series " + String.valueOf(i + 1));
            System.out.println("---------------------------------------------------------");
            System.out.println("SERIES ID: " + series.SeriesID);
            System.out.println("SERIES NAME: " + series.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
            System.out.println("NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
            System.out.println("---------------------------------------------------------");
        }
    }
    
    //Method to exit application
    public void ExitSeriesApplication() {
        System.out.println("Closing application...");
        scanner.close();
        System.exit(0);
    }
    
    //Method for age validation
    private String getValidAge() {
        String ageInput;
        int ageValue;
        
        while (true) {
            System.out.println("Enter the series age restriction: ");
            ageInput = scanner.nextLine().trim();
            
            if (!ageInput.matches("\\d+")) {
                System.out.println("Please enter a valid number value!");
                continue;
            }
            
            try {
                ageValue = Integer.parseInt(ageInput);
                
                if (ageValue >= 2 && ageValue <= 18) {
                    return ageInput;
                } else {
                    System.out.println("Age restriction must be between 2 and 18!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format!");
            }
        }
    }
    
    //Method for generating menu and receiving user input
    public int displayMenu() {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new series");
        System.out.println("(2) Search for a series");
        System.out.println("(3) Update series age restriction");
        System.out.println("(4) Delete a series");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit application");
        
        String choiceStr = scanner.nextLine().trim();
        
        if (choiceStr.isEmpty()) {
            return 0; //Invalid choice
        }
        
        try {
            return Integer.parseInt(choiceStr);
        } catch (NumberFormatException e) {
            return 0; //Invalid choice
        }
    }
}   

