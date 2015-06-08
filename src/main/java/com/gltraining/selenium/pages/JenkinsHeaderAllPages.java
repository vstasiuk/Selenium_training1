package com.gltraining.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by vasyl.stasiuk on 5/26/2015.
 */
public class JenkinsHeaderAllPages {
    private  static FirefoxDriver driver;
    private WebDriver wd;

    @FindBy(linkText = "log in")
    private WebElement loginLink;

    @FindBy(linkText = "sign up")
    private WebElement signUpLink;

    @FindBy (linkText = "log out")
    private WebElement logOutLink;

    @FindBy (id  = "search-box")
    private WebElement searchBox;

    @FindAll({@FindBy(xpath = "//div[@id='search-box-completion']//li")})
    private List<WebElement> searchResults;

    @FindBy(linkText = "Delete")
    private WebElement deleteLink;

    public JenkinsHeaderAllPages(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public JenkinsLoginPage clickLogin(){
        loginLink.click();
        return new JenkinsLoginPage(wd);
    }

    public JenkinsSignUpPage clickSignUp(){
        signUpLink.click();
        return new JenkinsSignUpPage(wd);
    }


    public JenkinsHeaderAllPages clickLogOut(){
        logOutLink.click();
        return new JenkinsHeaderAllPages(wd);
    }

    private WebElement getSearchResult(String searchedText){
        for (int i = 0; i < searchResults.size(); i++) {
            WebElement element = searchResults.iterator().next();
            String text = element.getText();
            if(text.contains(searchedText)){
                return element;
            }
        }
    //    log.warn("There is no result with text: '" + searchedText + "' among " + results.size() + " results");
        return null;
    }

    public JenkinsUserHomePage clickSearchResult(String searchText, String resultText){
        searchBox.sendKeys(searchText);
        WebElement webElement = getSearchResult(resultText);
        assert webElement != null;
        webElement.click();
        searchBox.sendKeys(Keys.RETURN);
        return new JenkinsUserHomePage(wd);
        }

    public JenkinsUserHomePage clickDeleteLink(){
        deleteLink.click();
        return new JenkinsUserHomePage(wd);
    }

    public JenkinsHeaderAllPages waitForElemenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(deleteLink));
        return this;
    }

    }
