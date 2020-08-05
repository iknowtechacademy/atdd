package com.iknow.atdd;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductTestNGTest {

    private WebDriver driver;

    public ProductTestNGTest() {
    }

    @BeforeTest
    public void setBaseURL() throws Exception {

        String path = "/Users/Shared/Jenkins/Home/workspace/Atdd/chromedriver3";
        
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

    }

    @Test
    public void verifyHomePage() {

        String baseUrl = "http://localhost:9090/JsfDemoApp/faces/welcomeJSF.jsp";
        
        driver.get(baseUrl);
        WebElement link = driver.findElement(By.xpath("//*[@id=\"j_id_jsp_416426823_1\"]/a"));
        link.click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        WebElement h1 = driver.findElement(By.tagName("h1"));

        //Verificacion
        Assert.assertEquals(h1.getText(), "Listing Product Items");

    }

    @AfterTest
    public void endSession() throws Exception {
        driver.quit();
    }

}
