package com.company.incomplete;

import com.company.*; //TODO*calls all classes?
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JobTests {
    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly

    private static final Job testJob1 = new Job();
    private static final Job testJob2 = new Job();
    private static final Job testJob3 = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
    private static final Job testJob4 = new Job("Web Developer",
            new Employer("LaunchCode"),
            new Location("St. Louis"),
            new PositionType("Front-end developer"),
            new CoreCompetency("JavaScript"));
    private static final Job testJob5 = new Job("Web Developer",
            new Employer("LaunchCode"),
            new Location("St. Louis"),
            new PositionType("Front-end developer"),
            new CoreCompetency("JavaScript"));
    private static final Job testJob6 = new Job("Product tester",
            new Employer(""),
            new Location(""),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
    private static final Job testJob7 = new Job("",
            new Employer(""),
            new Location(""),
            new PositionType(""),
            new CoreCompetency(""));


    @Test
    public void testSettingJobId() {
        //create 2 objs using default constructor
        //check 2 ids of both objs differ by 1
        Assertions.assertEquals(1, testJob2.getId()-testJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Assertions.assertTrue(testJob3 instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Assertions.assertFalse(testJob4.equals(testJob5));
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        //checks for beginning and ending blank line
        Assertions.assertTrue(testJob3.toString().startsWith("\n"));
        Assertions.assertTrue(testJob3.toString().endsWith("\n"));
    }

    @Test
    public void testToStringHasLabelsForEachField() {
        Assertions.assertTrue(testJob6.toString().contains("ID: "));
        Assertions.assertTrue(testJob6.toString().contains("Name: "));
        Assertions.assertTrue(testJob6.toString().contains("Employer: "));
        Assertions.assertTrue(testJob6.toString().contains("Location: "));
        Assertions.assertTrue(testJob6.toString().contains("Position Type: "));
        Assertions.assertTrue(testJob6.toString().contains("Core Competency: "));
    }

    @Test
    public void testToStringDataNotAvailable() {
        Assertions.assertTrue(testJob6.toString().contains("Employer: Data not available"));
        Assertions.assertTrue(testJob6.toString().contains("Location: Data not available"));
    }

    @Test
    public void testToStringJobDoesNotExist() {
        Assertions.assertTrue(testJob7.toString().contains("OOPS! This job does not seem to exist."));
    }
}
