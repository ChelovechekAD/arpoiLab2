package org.ITAcademy.part1;

import org.ITAcademy.part1.utils.MockUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected static WebDriver driver;


    @BeforeClass
    static void setUp() {
        driver = MockUtils.getDriver();
    }

    @AfterClass
    static void tearDown() {
        MockUtils.closeDriver();
    }
}
