package org.ITAcademy.part1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptAlertsTest extends BaseTest{

    @Test
    public void testJSAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        alert.accept();
        WebElement result = driver.findElement(By.id("result"));

        String resultText = result.getText();
        assertEquals(List.of(alertText, resultText), List.of("I am a JS Alert", "You successfully clicked an alert"));
    }

    @Test
    public void testJSConfirm() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        alert.dismiss();
        WebElement result = driver.findElement(By.id("result"));

        String resultText = result.getText();
        assertEquals(List.of(alertText, resultText), List.of("I am a JS Confirm", "You clicked: Cancel"));

    }

    @Test
    public void testJSPrompt() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Alert alert = driver.switchTo().alert();
        String inputText = "Test input";
        alert.sendKeys(inputText);
        String alertText = alert.getText();

        alert.accept();
        WebElement result = driver.findElement(By.id("result"));

        String resultText = result.getText();
        assertEquals(List.of(alertText, resultText), List.of("I am a JS prompt", "You entered: " + inputText));
    }
}
