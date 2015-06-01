package com.gltraining.selenium.utils;

import com.sun.istack.internal.NotNull;

/**
 * Created by vasyl.stasiuk on 5/28/2015.
 */
public enum Browser {
    CHROME,
    FIREFOX,
    IE;

    private static Browser browser = null;

    @NotNull
    public static Browser getCurrentBrowser() {
        if (browser == null) {
            browser = Browser.valueOf(System.getProperty("browser", "chrome").toUpperCase());
        }
        return browser;
    }
}