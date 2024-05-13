package org.ITAcademy.part1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasicAuthTest extends BaseTest {

    @Test
    public void testBasicAuth() {
        String email = "admin";
        String password = "admin";
        String urlTemplate = "https://%s:%s@the-internet.herokuapp.com/basic_auth";
        driver.get(String.format(urlTemplate, email, password));
        String h1Text = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        assertEquals(h1Text, "Basic Auth");
    }

}
