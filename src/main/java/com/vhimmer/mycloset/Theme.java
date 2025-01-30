package com.vhimmer.mycloset;

public enum Theme {
    LIGHT("/light.css"),
    DARK("/dark.css"),
    BLUE("/blue.css"),
    PINK("/pink.css");

    private final String stylesheetPath;
    private static Theme currentTheme = LIGHT;

    Theme(String stylesheetPath) {
        this.stylesheetPath = stylesheetPath;
    }

    public String getStylesheetPath() {
        return stylesheetPath;
    }

    public static Theme getCurrentTheme() {
        return currentTheme;
    }

    public static void setCurrentTheme(Theme theme) {
        currentTheme = theme;
    }
}