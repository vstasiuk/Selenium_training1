package com.gltraining.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vasyl.stasiuk on 5/26/2015.
 */
public class JenkinsSignUpPage {
    private WebDriver wd;

    @FindBy (id = "username")
    private WebElement usernameField;

    @FindBy (name = "password1")
    private WebElement password1;

    @FindBy (name = "password2")
    private WebElement passwordConfirm;

    @FindBy (name = "fullname")
    private WebElement fullName;

    @FindBy (name = "email")
    private WebElement email;

    @FindBy (id = "yui-gen1-button")
    private WebElement signUpButton;


    public JenkinsSignUpPage(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public JenkinsSignUpPage setUsername (String value){
        usernameField.sendKeys(value);
        return new JenkinsSignUpPage(wd);
    }

    public JenkinsSignUpPage setPassword1 (String value){
        password1.sendKeys(value);
        return new JenkinsSignUpPage(wd);
    }

    public JenkinsSignUpPage setPasswordConfirm (String value){
        passwordConfirm.sendKeys(value);
        return new JenkinsSignUpPage(wd);
    }

    public JenkinsSignUpPage setFullName (String value){
        fullName.sendKeys(value);
        return new JenkinsSignUpPage(wd);
    }

    public JenkinsSignUpPage setEmaail (String value){
        email.sendKeys(value);
        return new JenkinsSignUpPage(wd);
    }

    public JenkinsUserHomePage signUpClick(){
        signUpButton.click();
        return new JenkinsUserHomePage(wd);
    }

}
