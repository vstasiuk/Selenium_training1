package com.gltraining.selenium.pages;

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

    public JenkinsLoginPage setLoginValue(String value){
        userLoginField.sendKeys(value);
        return new JenkinsLoginPage(wd);
    }
    public JenkinsLoginPage setPasswordValue(String value){
        passwordField.sendKeys(value);
        return new JenkinsLoginPage(wd);
    }

    public JenkinsUserHomePage loginButtonClick (){
        loginButton.click();
        return new JenkinsUserHomePage(wd);
    }
//    public com.gltraining.selenium.pages.JenkinsLoginPage
}
