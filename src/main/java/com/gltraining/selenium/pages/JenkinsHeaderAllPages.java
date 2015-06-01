package com.gltraining.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vasyl.stasiuk on 5/26/2015.
 */
public class JenkinsHeaderAllPages {
    private WebDriver wd;

    @FindBy(linkText = "log in")
    private WebElement loginLink;

    @FindBy(linkText = "sign up")
    private WebElement signUpLink;

    @FindBy (linkText = "log out")
    private WebElement logOutLink;

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
}