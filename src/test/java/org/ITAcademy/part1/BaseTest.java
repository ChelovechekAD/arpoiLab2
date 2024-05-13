package org.ITAcademy.part1;

import org.ITAcademy.part1.utils.MockUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    protected static WebDriver driver;


    @BeforeSuite
    static void setUp() {
        driver = MockUtils.getDriver();
    }

    @AfterSuite
    static void tearDown() {
        MockUtils.closeDriver();
    }
}
