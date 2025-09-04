package seriesapplication.test;


public class TestRunner {
    
    private static int testsPassed = 0;
    private static int testsFailed = 0;
    
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------");
        System.out.println("                SERIES APP - TEST SUITE                   ");
        System.out.println("----------------------------------------------------------");
        
        //Creating a test instance
        SeriesTest tester = new SeriesTest();
        
        //Run each test manually
        runTest("TestSearchSeries", () -> {
           tester.setUp();
           tester.TestSearchSeries();
           tester.tearDown();
        });
        
        runTest("TestSearchSeries_SeriesNotFound", () -> {
           tester.setUp();
           tester.TestSearchSeries_SeriesNotFound();
           tester.tearDown();
        });
        
        runTest("TestUpdateSeries", () -> {
           tester.setUp();
           tester.TestUpdateSeries();
           tester.tearDown();
        });
        
        runTest("TestDeleteSeries", () -> {
           tester.setUp();
           tester.TestDeleteSeries();
           tester.tearDown();
        });
        
        runTest("TestDeleteSeries_SeriesNotFound", () -> {
           tester.setUp();
           tester.TestDeleteSeries_SeriesNotFound();
           tester.tearDown();
        });
        
        runTest("TestSeriesAgeRestriction_AgeValid", () -> {
            tester.setUp();
            tester.TestSeriesAgeRestriction_AgeValid();
            tester.tearDown();
        });
        
        runTest("TestSeriesAgeRestriction_SeriesAgeInvalid", () -> {
           tester.setUp();
           tester.TestSeriesAgeRestriction_SeriesAgeInvalid();
           tester.tearDown();
        });
        
        //Displaying the results
        System.out.println("----------------------------------------------------------");
        System.out.println("                      TEST RESULTS                        ");
        System.out.println("----------------------------------------------------------");
        
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + testsFailed);
        System.out.println("Total Tests: " + (testsPassed + testsFailed));
        
        if (testsFailed == 0) {
            System.out.println("\nAll tests passed successfully!");
        } else {
            System.out.println("\n" + testsFailed + " test(s) failed. Review output above.");
        }
    }
    
    private static void runTest(String testName, Runnable test) {
        try {
            System.out.println("Running " + testName + "...");
            test.run();
            System.out.println("PASSED");
            testsPassed++;
        } catch (AssertionError | Exception e) {
            System.out.println("FAILED");
            System.out.println("Reason: " + e.getMessage());
            testsFailed++;
        }
    }
}
