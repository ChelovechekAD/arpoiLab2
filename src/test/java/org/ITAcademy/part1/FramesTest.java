package org.ITAcademy.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTest extends BaseTest {

    @Test
    public void nestedFrames() throws Exception {
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement contentElement = driver.findElement(By.id("content"));
        String contentText = contentElement.getText();
        Assert.assertEquals(contentText, "MIDDLE");
    }

    @Test
    public void iFrames() throws Exception {
        driver.get("http://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        String newText = "Hello World!";
        editor.sendKeys(newText);
        String afterText = editor.getText();
        driver.switchTo().defaultContent();
        WebElement headingElement = driver.findElement(By.cssSelector("h3"));
        String headingText = headingElement.getText();
        Assert.assertEquals(List.of(beforeText, afterText, headingText),
                List.of("Your content goes here.", newText, "An iFrame containing the TinyMCE WYSIWYG Editor"));
        Assert.assertNotEquals(afterText, beforeText);
    }
}
