package com.gltraining.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vasyl.stasiuk on 5/26/2015.
 */
public class JenkinsSingUpPage {
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

    public JenkinsSingUpPage(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }


}
