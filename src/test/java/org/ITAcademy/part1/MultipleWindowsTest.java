package org.ITAcademy.part1;

import org.ITAcademy.part1.utils.MockUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MultipleWindowsTest extends BaseTest{

    @Test
    public void testNewWindow() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        MockUtils.switchToNewWindow();
        String currentUrl = driver.getCurrentUrl();
        boolean contains = currentUrl.contains("/windows/new");
        assertTrue(contains);
    }

}
