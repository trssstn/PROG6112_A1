package seriesapplication;


public class SeriesModel {
    public String SeriesID;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    
    //CONSTRUCTOR
    public SeriesModel(String SeriesID, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes) {
        this.SeriesID = SeriesID;
        this.SeriesName = SeriesName;
        this.SeriesAge = SeriesAge;
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    
    //Override toString() for easy displaying
    @Override
    public String toString() {
        return "SERIES ID: " + SeriesID + "\nSERIES NAME: " + SeriesName + "\nSERIES AGE RESTRICTION: " + SeriesAge + "\nNUMBER OF EPISODES: " + SeriesNumberOfEpisodes;
    }
}
