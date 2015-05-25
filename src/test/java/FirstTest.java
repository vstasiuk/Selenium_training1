package com.gl.testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
    private  static FirefoxDriver driver;


    @BeforeClass
    public static  void  startUpBrowser(){

        driver = new FirefoxDriver();
        driver.get("http://seltr-kbp1-1.synapse.com:8080/");
    }

    @Test
    public void Login (){

  /*      //Click login link
        driver.findElement(By.linkText("log in")).click();

        // Enter correct login and password and confirm
        WebElement loginNameField = driver.findElement(By.id("j_username"));
        WebElement passwordField = driver.findElement(By.name("j_password"));
        loginNameField.sendKeys("vstasiuk");
        passwordField.sendKeys("Te$t321");
        WebElement loginButton = driver.findElement(By.id("yui-gen1-button"));
        loginButton.click();

        //Verify correct page is loaded
        WebElement User_Name = driver.findElement(By.linkText("Vasyl Stasiuk"));

        //Test log out
        driver.findElement(By.linkText("log out")).click();

        //Verify Login field is required (try login with blank log in field)
        driver.findElement(By.linkText("log in")).click();
        driver.findElement(By.name("j_password")).sendKeys("Te$t321");
        driver.findElement(By.id("yui-gen1-button")).click();

        //Verify error is shown (TBD)

        //driver.findElement(By.linkText("Invalid login information. Please try again."));
        //driver.findElement(By.xpath("//div[@id=\"main-panel-content\"]/div")).getText().trim().contains("Invalid login information. Please try again.");
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\"main-panel-content\"]/div")).getText().trim(), "Invalid login information. Please try again. Try again");


        //Verify incorrect password
        driver.findElement(By.linkText("log in")).click();
        driver.findElement(By.id("j_username")).sendKeys("vstasiuk");
        driver.findElement(By.name("j_password")).sendKeys("qwerty123");
        driver.findElement(By.id("yui-gen1-button")).click();
        //Verify error is shown



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }*/

    }
    @Test
    public void SignUp(){
        driver.findElement(By.linkText("sign up")).click();
        // Click Sign up without data in fields
        driver.findElement(By.id("yui-gen1-button")).click();
        //Verify error is shown (TBD)

//        Verify user can be created
        driver.findElement(By.linkText("sign up")).click();
        driver.findElement(By.id("username")).sendKeys("vsTest1_name");
        driver.findElement(By.name("password1")).sendKeys("Te$t321_1");
        driver.findElement(By.name("password2")).sendKeys("Te$t321_1");
        driver.findElement(By.name("fullname")).sendKeys("vs test full name");
        driver.findElement(By.name("email")).sendKeys("vstasiuk+1@gmail.com");
        driver.findElement(By.id("yui-gen1-button")).click();

//        Verify e-mail field (TBD)

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @AfterClass
    public  static  void sheetDownActivities(){
        driver.quit();
    }
}
