package org.ITAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.*;

public class DynamicControlsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setDriver() {
        driver = MockUtils.getDriver();
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

    @AfterClass
    public void closeUp() {
        MockUtils.closeDriver();
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
