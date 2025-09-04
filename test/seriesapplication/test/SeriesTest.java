package seriesapplication.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import seriesapplication.Series;
import seriesapplication.SeriesModel;


public class SeriesTest {
    
    private Series seriesManager;
    
    @BeforeEach
    public void setUp() {
        //Create new Series instance for each test
        seriesManager = new Series();
        
        //Add sample data for testing
        seriesManager.addSeries("001", "Breaking Bad", "18", "62");
        seriesManager.addSeries("002", "Arcane", "16", "24");
        seriesManager.addSeries("003", "Bojack Horseman", "13", "46");
    }
    
    @AfterEach
    public void tearDown() {
        //Clear data after each test
        seriesManager.clearAllSeries();
        seriesManager = null;
    }
    
    //Test 1: Test searching for an existing series
    @Test
    @DisplayName("Test Search Series - Series Found")
    public void TestSearchSeries() {
        SeriesModel foundSeries = seriesManager.findSeriesByID("001");
        
        assertNotNull(foundSeries, "Series should be found");
        assertEquals("001", foundSeries.SeriesID, "Series ID should match");
        assertEquals("Breaking Bad", foundSeries.SeriesName, "Series Name should match");
        assertEquals("18", foundSeries.SeriesAge, "Series Age should match");
        assertEquals("62", foundSeries.SeriesNumberOfEpisodes, "Series Episodes should match");
        
        System.out.println("TestSearchSeries: PASSED - Series found successfully.");
    }
    
    //Test 2: Test searching for non-existent series
    @Test
    @DisplayName("Test Search Series - Series Not Found")
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel foundSeries = seriesManager.findSeriesByID("999");
        
        assertNull(foundSeries, "Series should not be found");
        
        System.out.println("TestSearchSeries_SeriesNotFound: PASSED - Series not found as expected.");
    }
    
    //Test 3: Test updating an existing series
    @Test
    @DisplayName("Test Update Series - Success")
    public void TestUpdateSeries() {
        boolean updateResult = seriesManager.updateSeriesByID("002", "Arcane 2025", "13", "72");
        
        assertTrue(updateResult, "Update should be successful");
        
        //Verify the update
        SeriesModel updatedSeries = seriesManager.findSeriesByID("002");
        assertNotNull(updatedSeries, "Updated series should exist");
        assertEquals("Arcane 2025", updatedSeries.SeriesName, "Name should be updated");
        assertEquals("13", updatedSeries.SeriesAge, "Age should be updated");
        assertEquals("72", updatedSeries.SeriesNumberOfEpisodes, "Episodes should be updated");
        
        System.out.println("TestUpdateSeries: Passed - Series updated successfully.");
    }
    
    //Test 4: Test deleting an existing series
    @Test
    @DisplayName("Test Delete Series - Success")
    public void TestDeleteSeries() {
        boolean deleteResult = seriesManager.deleteSeriesByID("003");
        
        assertTrue(deleteResult, "Deletion should be successful");
        
        //Verifying deletion
        SeriesModel deletedSeries = seriesManager.findSeriesByID("003");
        assertNull(deletedSeries, "Deleted series should not exist");
        
        //Verify arraylist size decreased
        assertEquals(2, seriesManager.getSeriesList().size(), "Series list should have 2 items");
        
        System.out.println("TestDeleteSeries: PASSED - Series deleted successfully");
    }
    
    //Test 5: Test deleting non-existent series
    @Test
    @DisplayName("Test Delete Series - Series Not Found")
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleteResult = seriesManager.deleteSeriesByID("999");
        
        assertFalse(deleteResult, "Deletion should fail for non-existent series");
        
        //Verify arraylist size remains unchanged
        assertEquals(3, seriesManager.getSeriesList().size(), "Series list should still have 3 items");
        
        System.out.println("TestDeleteSeries_SeriesNotFound: PASSED - Series not deleted as expected");
    }
    
    //Test 6: Test valid age restriction
    @Test
    @DisplayName("Test Age Restriction - Valid Age")
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(seriesManager.isValidAgeRestriction("2"), "Age 2 should be valid");
        assertTrue(seriesManager.isValidAgeRestriction("10"), "Age 10 should be valid");
        assertTrue(seriesManager.isValidAgeRestriction("18"), "Age 18 should be valid");
        assertTrue(seriesManager.isValidAgeRestriction("13"), "Age 13 should be valid");
        
        System.out.println("TestSeriesAgeRestriction_AgeValid: PASSED - Valid ages accepted");
    }
    
    //Test 7: Test invalid age restriction
    @Test
    @DisplayName("Test Age Restriction - Invalid Age")
    public void TestSeriesAgeRestriction_SeriesAgeInvalid() {
        assertFalse(seriesManager.isValidAgeRestriction("1"), "Age 1 should be invalid");
        assertFalse(seriesManager.isValidAgeRestriction("19"), "Age 19 should be invalid");
        assertFalse(seriesManager.isValidAgeRestriction("0"), "Age 0 should be invalid");
        assertFalse(seriesManager.isValidAgeRestriction("-5"), "Age -5 should be invalid");
        assertFalse(seriesManager.isValidAgeRestriction("abc"), "Text should be invalid");
        assertFalse(seriesManager.isValidAgeRestriction("15!"), "Special characters should be invalid");
        assertFalse(seriesManager.isValidAgeRestriction(""), "Empty string should be invalid");
        assertFalse(seriesManager.isValidAgeRestriction(null), "Null should be invalid");
        
        System.out.println("TestSeriesAgeRestriction_SeriesAgeInvalid: PASSED - Invalid ages rejected");
    }
    
    //Additional tests to verify all the tests together
    @Test
    @DisplayName("Test All Operations Together")
    public void TestAllOperations() {
        //Clear all existing data in memory
        seriesManager.clearAllSeries();
        
        //Test add series
        seriesManager.addSeries("Test01", "Test Series", "15", "99");
        assertEquals(1, seriesManager.getSeriesList().size());
        
        //Test search series
        assertNotNull(seriesManager.findSeriesByID("Test01"));
        
        //Test update series
        seriesManager.updateSeriesByID("Test01", "Updated name", "17", "101");
        SeriesModel updated = seriesManager.findSeriesByID("Test01");
        assertEquals("Updated Series", updated.SeriesName);
        
        //Test delete series
        seriesManager.deleteSeriesByID("Test01");
        assertNull(seriesManager.findSeriesByID("Test01"));
        
        System.out.println("TestAllOperations: PASSED - All operations work together");
    }
}
