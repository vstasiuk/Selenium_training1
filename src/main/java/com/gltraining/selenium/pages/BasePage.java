package com.gltraining.selenium.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by vasyl.stasiuk on 6/2/2015.
 */

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {

    public static final int TIME_WAIT_SECONDS = 10;
    private static final int SCRIPT_TIME_OUT_WAIT_SECONDS = 120;
    private static final int PAGE_LOAD_TIME_WAIT_SECONDS = 600;

    private Wait visibilityWait;
    private Wait invisibilityWait;

   // protected final Logger log = LogManager.getLogger(this);
    private final WebDriver wd;

    private static Properties props = new Properties();
    public BasePage(WebDriver wd) {
        this.wd = wd;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream webStream = loader.getResourceAsStream("env.properties");
        try {
            props.load(webStream);
            webStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        visibilityWait = new FluentWait<WebDriver>(getWebDriverCurrent())
                .withTimeout(TIME_WAIT_SECONDS * 20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        invisibilityWait
                = new FluentWait<WebDriver>(getWebDriverCurrent())
                .withTimeout(TIME_WAIT_SECONDS * 20, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        PageFactory.initElements(wd, this);
    }

    protected static Properties getProps() {
        return props;
    }

    public static String getPageURL() {
        return BasePage.props.getProperty("application.url");
    }

//    protected abstract void checkUniqueElements() throws Error;

    protected WebDriver getWebDriverCurrent() {
        return wd;
    }
}
