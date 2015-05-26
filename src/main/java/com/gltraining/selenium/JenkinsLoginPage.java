package com.gltraining.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vasyl.stasiuk on 5/26/2015.
 */
public class JenkinsLoginPage {
    private WebDriver wd;

    @FindBy(id = "j_username")
    private WebElement userLoginField;

    @FindBy(name = "j_password")
    private WebElement passwordField;

    @FindBy(id = "yui-gen1-button")
    private WebElement loginButton;

    @FindBy(linkText = "Create an account")
    private WebElement createAnAccountLink;

    public JenkinsLoginPage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

//    public com.gltraining.selenium.JenkinsLoginPage
}
