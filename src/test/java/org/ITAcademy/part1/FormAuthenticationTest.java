package org.ITAcademy.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FormAuthenticationTest extends BaseTest{
    private boolean isErrorMessageDisplayed;

    @DataProvider(name = "userCredentials")
    public Object[][] testData(){
        return new Object[][] {
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!\n×"},
                {"tomsmith", "1", "Your password is invalid!\n×"},
                {"1", "SuperSecretPassword!", "Your username is invalid!\n×" }
        };
    }

    @Test (dataProvider = "userCredentials")
    public void testLogin(String login, String password, String message) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        driver.findElement(By.cssSelector("button.radius")).click();

        WebElement successMessage = driver.findElement(By.id("flash"));
        String successText = successMessage.getText();

        assertEquals(successText, message);
    }

}

