package org.ITAcademy.part1;

import org.ITAcademy.part1.utils.MockUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertTrue;

public class JQueryUIMenusTest extends BaseTest {

    @Test()
    public void testDownloadPDF() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
        driver.findElement(By.xpath("//a[contains(text(),'Enabled')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Downloads')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'PDF')]")).click();
        Thread.sleep(1000);
        File pdfFile = MockUtils.getFileByName("menu.pdf");
        boolean exist = pdfFile.exists();
        Optional.of(exist).filter(p -> p).ifPresent(e -> pdfFile.delete());
        assertTrue(exist, "PDF file not downloaded successfully.");
    }

    @Test()
    public void testDownloadCSV() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
        driver.findElement(By.xpath("//a[contains(text(),'Enabled')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Downloads')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'CSV')]")).click();
        Thread.sleep(1000);
        File csvFile = MockUtils.getFileByName("menu.csv");
        boolean exist = csvFile.exists();
        Optional.of(exist).filter(p -> p).ifPresent(e -> csvFile.delete());
        assertTrue(exist, "CSV file not downloaded successfully.");
    }

    @Test()
    public void testDownloadExcel() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
        driver.findElement(By.xpath("//a[contains(text(),'Enabled')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Downloads')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Excel')]")).click();
        Thread.sleep(1000);
        File excelFile = MockUtils.getFileByName("menu.xls");
        boolean exist = excelFile.exists();
        Optional.of(exist).filter(p -> p).ifPresent(e -> excelFile.delete());
        assertTrue(exist, "Excel file not downloaded successfully.");
    }

    @Test
    public void testBackToJQueryUI() {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
        driver.findElement(By.xpath("//a[contains(text(),'Enabled')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Back to JQuery UI')]")).click();
        String h2Text = driver.findElement(By.xpath("//div[@id='content']/div[@class='example']/h3")).getText();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(List.of(h2Text, currentUrl), List.of("JQuery UI", "https://the-internet.herokuapp.com/jqueryui"));
    }

}