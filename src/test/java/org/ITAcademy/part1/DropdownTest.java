package org.ITAcademy.part1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTest{

    @Test
    public void testDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//*[@id='dropdown']/option[@value='1']")).click();
        String selected = driver.findElement(By.xpath("//*[@id='dropdown']/option[@value='1']"))
                .getAttribute("selected");
        assertEquals(selected, "true");
    }

}
