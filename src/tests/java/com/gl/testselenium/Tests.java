package com.gl.testselenium;

            import com.gltraining.selenium.pages.JenkinsHeaderAllPages;
            import com.gltraining.selenium.pages.JenkinsLoginPage;
            import com.gltraining.selenium.pages.JenkinsSignUpPage;
            import org.openqa.selenium.By;
            import org.openqa.selenium.WebElement;
            import org.openqa.selenium.firefox.FirefoxDriver;
            import org.testng.Assert;
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
        String fullUserName = "Full name for " + userName;

        //Verify user can be created
        jenkinsHeaderAllPages.clickSignUp();
        jenkinsSignUpPage.setUsername(userName);
        jenkinsSignUpPage.setPassword1(password);
        jenkinsSignUpPage.setPasswordConfirm(password);
        jenkinsSignUpPage.setFullName(fullUserName);
        jenkinsSignUpPage.setEmaail("vstasiuk+" + userId + "@gmail.com");
        jenkinsSignUpPage.signUpClick();

        //Verify Success
        String userNameOnPage = driver.findElement(By.xpath("//*[@id=\"header\"]/div[@class=\"login\"]/span/a[@class=\"model-link inside inverse\"]/b")).getText().trim();
        Assert.assertEquals(userNameOnPage, fullUserName);

        jenkinsHeaderAllPages.clickLogOut();
    }

    @Test
    public void bLogin() {
        //Click login link
        jenkinsHeaderAllPages = new JenkinsHeaderAllPages(driver);
        jenkinsLoginPage = new JenkinsLoginPage(driver);
        jenkinsHeaderAllPages.clickLogin();

        // Enter correct login and password and confirm
        jenkinsLoginPage.setLoginValue(userName);
        jenkinsLoginPage.setPasswordValue(password);
        jenkinsLoginPage.loginButtonClick();
        //WebElement User_Name = driver.findElement(By.linkText("Vasyl Stasiuk"));

        //jenkinsHeaderAllPages.clickLogOut(); // need add exception(TBD)
       // Assert.assertEquals();
       /*

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
