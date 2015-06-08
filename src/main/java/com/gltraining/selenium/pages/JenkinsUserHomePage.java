package com.gltraining.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vasyl.stasiuk on 6/1/2015.
 */
public class JenkinsUserHomePage {
    private WebDriver wd;

    @FindBy(linkText = "People")
    private WebElement peopleLink;

    @FindBy(id = "search-box")
    private WebElement searchField;

    @FindBy(id = "yui-gen1-button")
    private WebElement confirmButton;

    public JenkinsUserHomePage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd, this);
    }

    public JenkinsUserHomePage clickPeople(){
        peopleLink.click();
        return new JenkinsUserHomePage(wd);
    }

    public JenkinsUserHomePage clickConfirmButton(){
        //Check that button exist (TBD)
        confirmButton.click();
        return new JenkinsUserHomePage(wd);
    }

    public JenkinsUserHomePage setValueToSearchField(){
        return new JenkinsUserHomePage(wd);
    }
}
