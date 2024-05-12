package org.ITAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTest {

    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        driver = MockUtils.getDriver();
    }

    @Test
    public void testDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//*[@id='dropdown']/option[@value='1']")).click();
        String selected = driver.findElement(By.xpath("//*[@id='dropdown']/option[@value='1']"))
                .getAttribute("selected");
        assertEquals(selected, "true");
    }

    @AfterClass
    public void closeUp() {
        MockUtils.closeDriver();
    }

}
