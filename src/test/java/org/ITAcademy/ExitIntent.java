package org.ITAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExitIntent {
    private static WebDriver driver;

    @BeforeClass
    static void setUp() {
        driver = MockUtils.getDriver();
    }

    @AfterClass
    static void tearDown() {
        MockUtils.closeDriver();
    }

    @Test
    public void testExitIntent() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/exit_intent");

        Actions actions = new Actions(driver);

        WebElement triggerArea = driver.findElement(By.id("ouibounce-modal"));

        Thread.sleep(1000);

        WebElement modalTitle = driver.findElement(By.xpath("//*[@id='ouibounce-modal']" +
                "/*[@class='modal']" +
                "/*[@class='modal-body']/p"));
        WebElement test = driver.findElement(By.xpath("//*[@id='ouibounce-modal']"));
        System.out.println("Modal title text: " + modalTitle.getText() + " " + test.getAttribute("style"));
    }
}
