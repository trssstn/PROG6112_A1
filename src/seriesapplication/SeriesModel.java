package seriesapplication;


public class SeriesModel {
    public String SeriesID;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    
    // Constructor
    public SeriesModel(String SeriesID, String SeriesName, 
                      String SeriesAge, String SeriesNumberOfEpisodes) {
        this.SeriesID = SeriesID;
        this.SeriesName = SeriesName;
        this.SeriesAge = SeriesAge;
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    
    // Override toString() for easy display
    @Override
    public String toString() {
        return "Series ID: " + SeriesID + 
               ", Name: " + SeriesName + 
               ", Age Rating: " + SeriesAge + 
               ", Episodes: " + SeriesNumberOfEpisodes;
    } 
}
