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

        String path = "/Users/Shared/Jenkins/Home/workspace/Curso_atdd/chromedriver3";
        
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

    }

    @Test
    public void verifyHomePage() {

        String baseUrl = "http://localhost:9090/JsfDemoApp/faces/welcomeJSF.jsp";
        
        driver.get(baseUrl);
        //
        //
        //
        //By.linkText("Show All Product Items")
        WebElement productsLink = driver.findElement(By.xpath("//*[@id=\"j_id_jsp_416426823_1:linkProds\"]"));
        
        productsLink.click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        //Siguiente pagina Web
        WebElement h1 = driver.findElement(By.tagName("h1"));
        
        //Verificacion
        Assert.assertEquals(h1.getText(), "Listing Product Items");

    }
    
    
    @Test
    public void createTest() {

        String baseUrl = "http://localhost:9090/JsfDemoApp/faces/welcomeJSF.jsp";
        
        driver.get(baseUrl);
        //
        //By.linkText("Show All Product Items")
        WebElement productsLink = driver.findElement(By.xpath("//*[@id=\"j_id_jsp_416426823_1:linkProds\"]"));
        
        productsLink.click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        //Siguiente pagina Web
        WebElement h1 = driver.findElement(By.tagName("h1"));
        
        //Link 'New Product'
        WebElement linkNew = driver.findElement(By.xpath("//*[@id=\"j_id_jsp_2101894059_2\"]/a[1]"));
        linkNew.click();
        
        String productIdValue = "1";
        //Llenar Form
        WebElement productId = driver.findElement(By.id("j_id_jsp_1869794631_2:productId"));
        productId.sendKeys(productIdValue);
        
        WebElement purchaseCost = driver.findElement(By.id("j_id_jsp_1869794631_2:purchaseCost"));
        purchaseCost.sendKeys("100");
        
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"j_id_jsp_1869794631_2\"]/a[1]"));
        createButton.click();
        
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        //En la pagina del listado de productos
        WebElement nuevoProductId = driver.findElement(By.id("j_id_jsp_2101894059_2:j_id_jsp_2101894059_9:0:productIdColumn"));

        //Verificacion
        Assert.assertEquals(nuevoProductId.getText(), productIdValue);

    }

    @AfterTest
    public void endSession() throws Exception {
        driver.quit();
    }

}
