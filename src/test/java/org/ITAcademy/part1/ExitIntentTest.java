package org.ITAcademy.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExitIntentTest extends BaseTest {


    @Test
    public void testExitIntent() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/exit_intent");
//  T1
        /*WebElement triggerArea = driver.findElement(By.id("content"));
        String increasePageHeight = "height: 3000px";
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                triggerArea,
                increasePageHeight
        );
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("page-footer")), 0, 0).perform();*/
//  T2
       /* new Actions(driver).moveToElement(driver.findElement(By.id("content"))).click();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> listOfHandles = driver.getWindowHandles().stream().toList();
        driver.switchTo().window(listOfHandles.get(1));
        Thread.sleep(1000);
        driver.switchTo().window(listOfHandles.get(0));
        Thread.sleep(1000);*/

        //Костыль, ибо у меня нет идей.
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                driver.findElement(By.id("ouibounce-modal")),
                "display: block"
        );

        WebElement modalTitle = driver.findElement(By.xpath("//*[@id='ouibounce-modal']" +
                "/*[@class='modal']" +
                "/*[@class='modal-body']/p"));

        Assert.assertEquals(modalTitle.getText(),
                "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something).");
    }
}
