package org.ITAcademy;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AnnotationTestNG {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://the-internet.herokuapp.com/";

    @BeforeSuite
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("The setup process is completed");
    }

    @BeforeTest
    public void profileSetup() {
        driver.manage().window().maximize();
        System.out.println("The profile setup process is completed");
    }

    @BeforeClass
    public void appSetup() {
        driver.get(url);
        System.out.println("The app setup process is completed");
    }

    @Test()
    public void testBasicAuth() {
        String email = "admin";
        String password = "admin";
        String urlTemplate = "https://%s:%s@the-internet.herokuapp.com/basic_auth";
        driver.get(String.format(urlTemplate, email, password));
        String h1Text = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        assertEquals(h1Text, "Basic Auth");
    }

    @Test
    public void testDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//*[@id='dropdown']/option[@value='1']")).click();
        String selected = driver.findElement(By.xpath("//*[@id='dropdown']/option[@value='1']")).getAttribute("selected");
        assertEquals(selected, "true");
    }

    @Test(groups = "dynamicControls")
    public void testDynamicControlsCheckbox() {
        WebElement webElement = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        webElement.click();
        wait.until(ExpectedConditions.attributeToBe(webElement, "disabled", ""));
        assertThrows(NoSuchElementException.class, () -> driver.findElement(By.id("checkbox")));
    }

    @Test(groups = "dynamicControls")
    public void testDynamicControlsInput() {
        WebElement webElement = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        webElement.click();
        wait.until(ExpectedConditions.attributeToBe(webElement, "disabled", ""));
        assertNull(driver.findElement(By.xpath("//*[@id='input-example']/input")).getAttribute("disabled"));
    }



/*
    @Test(groups = "urlValidation")
    public void testCurrentUrl() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='app']/header/aside/ul/li[4]/a")).click();
        Thread.sleep(6000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://automation.lambdatest.com/timeline/?viewType=build&page=1", "url did not matched");
        System.out.println("The url validation test is completed");
    }
*/


    @AfterClass
    public void closeUp() {
        driver.close();
        System.out.println("The close_up process is completed");
    }

    @AfterTest
    public void reportReady() {
        System.out.println("Report is ready to be shared, with screenshots of tests");
    }

    @AfterSuite
    public void cleanUp() {
        System.out.println("All close up activities completed");
    }

    @BeforeGroups("dynamicControls")
    public void setUpSecurity() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @AfterGroups("dynamicControls")
    public void tearDownSecurity() {
        System.out.println("url validation test finished");
    }
}