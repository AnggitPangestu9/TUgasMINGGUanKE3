package com.juaracoding.tugaske3;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TugasMingguanKeTiga {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//INI PERINTAH BUAT NUNGGU 10 DETIK JIKA
        // TIDAK ADA ELEMENT YG DITEMUKAN MAKA ERROR
        //   JavascriptExecutor js= (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.findElement(By.id("first-name")).sendKeys("Evi");
        driver.findElement(By.id("last-name")).sendKeys("Landuk");
        driver.findElement(By.id("job-title")).sendKeys("software tester");

        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-2")).click();
        js.executeScript("window.scrollBy(0,700)");

        WebElement selectEkperience = driver.findElement(By.id("select-menu"));
        selectEkperience.click();
        Select pengalaman = new Select(selectEkperience);
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pengalaman.selectByValue("2");
        driver.findElement(By.id("datepicker")).click();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("datepicker")).sendKeys("11/12/2022");
        driver.findElement(By.linkText("Submit")).click();


        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("close web");
    }
}