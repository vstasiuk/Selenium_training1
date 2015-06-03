package com.gl.testselenium;

import com.gltraining.selenium.pages.JenkinsHeaderAllPages;
import com.gltraining.selenium.pages.JenkinsLoginPage;
import com.gltraining.selenium.pages.JenkinsSignUpPage;
import com.gltraining.selenium.pages.JenkinsUserHomePage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Tests {
    private  static FirefoxDriver driver;
    private JenkinsHeaderAllPages jenkinsHeaderAllPages;
    private JenkinsLoginPage jenkinsLoginPage;
    private JenkinsSignUpPage jenkinsSignUpPage;


    int userId = randomInt();
    String userName = "vsTest_name" + Integer.toString(userId);
    String password = "Te$t321_1";

    @BeforeClass
    public static  void  startUpBrowser(){
        driver = new FirefoxDriver();
        driver.get("http://seltr-kbp1-1.synapse.com:8080/");
    }


    @Test
    public void aSignUp(){
        jenkinsHeaderAllPages = new JenkinsHeaderAllPages(driver);
        jenkinsSignUpPage = new JenkinsSignUpPage(driver);

        //Verify user can be created
        jenkinsHeaderAllPages.clickSignUp();
        jenkinsSignUpPage.setUsername(userName);
        jenkinsSignUpPage.setPassword1(password);
        jenkinsSignUpPage.setPasswordConfirm(password);
        jenkinsSignUpPage.setFullName("Full name for " + userName);
        jenkinsSignUpPage.setEmaail("vstasiuk+" + userId + "@gmail.com");
        jenkinsSignUpPage.signUpClick();
        jenkinsHeaderAllPages.clickLogOut();
        //Verify Success (TBD)
    }

    @Test
    public void bLogin() {
        private final String mainUserName = "vstasiuk";
        private final String mainUserPassword = "Te$t321"

        //Click login link
        jenkinsHeaderAllPages = new JenkinsHeaderAllPages(driver);
        jenkinsLoginPage = new JenkinsLoginPage(driver);
        jenkinsHeaderAllPages.clickLogin();


        // Enter correct login and password and confirm
        jenkinsLoginPage.setLoginValue(userName);
        jenkinsLoginPage.setPasswordValue(password);
        jenkinsLoginPage.loginButtonClick();
        //jenkinsHeaderAllPages.clickLogOut(); // need add exception(TBD)

       /*

        //Verify correct page is loaded
        WebElement User_Name = driver.findElement(By.linkText("Vasyl Stasiuk"));

        //Test log out
        driver.findElement(By.linkText("log out")).click();

        //Verify Login field is required (try login with blank log in field)
        driver.findElement(By.linkText("log in")).click();
        driver.findElement(By.name("j_password")).sendKeys("Te$t321");
        driver.findElement(By.id("yui-gen1-button")).click();

        //Verify error is shown (TBD)
        String expected = "Invalid login information. Please try again.";
        //driver.findElement(By.linkText("Invalid login information. Please try again."));
        //driver.findElement(By.xpath("//div[@id=\"main-panel-content\"]/div")).getText().trim().contains("Invalid login information. Please try again.");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"main-panel-content\"]/div")).getText().trim().contains(expected));


        //Verify incorrect password
        driver.findElement(By.linkText("log in")).click();
        driver.findElement(By.id("j_username")).sendKeys("vstasiuk");
        driver.findElement(By.name("j_password")).sendKeys("qwerty123");
        driver.findElement(By.id("yui-gen1-button")).click();
        //Verify error is shown*/

/*        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }*/
    }

    @AfterClass
    public  static  void sheetDownActivities(){
        driver.quit();
    }
    //random int generator
    public int randomInt(){
        Random digits = new Random();
        return digits.nextInt(100);
    }
}
