package org.ITAcademy;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasicAuthTest {
    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        driver = MockUtils.getDriver();
    }

    @Test
    public void testBasicAuth() {
        String email = "admin";
        String password = "admin";
        String urlTemplate = "https://%s:%s@the-internet.herokuapp.com/basic_auth";
        driver.get(String.format(urlTemplate, email, password));
        String h1Text = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        assertEquals(h1Text, "Basic Auth");
    }

    @AfterClass
    public void closeUp() {
        MockUtils.closeDriver();
    }
}
