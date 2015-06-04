package com.gl.testselenium;

import com.gltraining.selenium.pages.JenkinsHeaderAllPages;
import com.gltraining.selenium.pages.JenkinsLoginPage;
import com.gltraining.selenium.pages.JenkinsUserHomePage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by vasyl.stasiuk on 6/2/2015.
 */
public class DeleteUsersTest {
    private  static FirefoxDriver driver;
    private JenkinsLoginPage jenkinsLoginPage;
    private JenkinsUserHomePage jenkinsUserHomePage;
    private JenkinsHeaderAllPages jenkinsHeaderAllPages;
    private String searchText = "vsTest";
    final String mainUserName = "vstasiuk" ;
    final String mainUserPassword = "Te$t321";

    @BeforeClass
    public static  void  startUpBrowser(){
        driver = new FirefoxDriver();
        driver.get("http://seltr-kbp1-1.synapse.com:8080/");
    }

    @Test
    public void deleteMyUsers(){ //in progress
        jenkinsHeaderAllPages = new JenkinsHeaderAllPages(driver);
        jenkinsUserHomePage = new JenkinsUserHomePage(driver);
        jenkinsLoginPage = new JenkinsLoginPage(driver);
        //login
//        jenkinsHeaderAllPages.clickLogin();
//        jenkinsLoginPage.userLogin(mainUserName, mainUserPassword);

        //find user to delete
        //jenkinsUserHomePage.clickPeople();
        jenkinsHeaderAllPages.searchAndClickOnFirstMatch(searchText);

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @AfterClass
    public  static  void sheetDownActivities(){
        driver.quit();
    }
}
