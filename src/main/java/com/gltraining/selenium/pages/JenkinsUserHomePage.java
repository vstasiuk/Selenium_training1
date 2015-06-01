package com.gltraining.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vasyl.stasiuk on 6/1/2015.
 */
public class JenkinsUserHomePage {
    private WebDriver wd;

    @FindBy(linkText = "log in")
    private WebElement loginLink;

    public JenkinsUserHomePage(WebDriver wd) {
        this.wd = wd;

    }
}
