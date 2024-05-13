package org.ITAcademy.part1.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class MockUtils {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            driver = openDriver();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

    private WebDriver openDriver() {
        ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-debugging-port=9222", "--headless", "--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static File getFileByName(String name) {
        return new File(Constants.downloadDir+"\\"+name);
    }

    public static void switchToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> handles = windowHandles.stream().toList();
        driver.switchTo().window(handles.get(handles.size()-1));
    }
}
