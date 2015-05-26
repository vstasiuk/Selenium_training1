package com.gltraining.selenium;

import com.gltraining.selenium.JenkinsLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vasyl.stasiuk on 5/26/2015.
 */
public class JenkinsHomePage {
    private WebDriver wd;

    @FindBy(linkText = "log in")
    private WebElement loginLink;

    @FindBy(linkText = "sign up")
    private WebElement signUpLink;

    public JenkinsHomePage(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public JenkinsLoginPage clickLogin(){
        loginLink.click();
        return new JenkinsLoginPage(wd);
    }
}
