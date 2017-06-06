package com.nunya.screenshooter;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    @Before
    public void setup() {

    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://digitalreasoning.com/");
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        Long scrollHeight = (Long) jse.executeScript("return document.documentElement.scrollHeight");
        int height = driver.manage().window().getSize().getHeight();
        int howmanyscrolls = scrollHeight.intValue() / height;
        for (int i = 0; i <= howmanyscrolls; i++) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(
                        "./target/screenshots/screenshot" +
                                Integer.toString(i) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            jse.executeScript("document.documentElement.scrollBy(0,768)");

        }


        System.out.printf("Height is: %d", height);
        System.out.println();
        System.out.printf("Scroll Height is: %d", scrollHeight);
        System.out.println();
        System.out.printf("Number of scrolls to bottom: %d", howmanyscrolls);
        System.out.println();
        driver.close();
    }

    @After
    public void cleanup() {

    }
}
