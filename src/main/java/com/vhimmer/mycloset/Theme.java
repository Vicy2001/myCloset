package com.vhimmer.mycloset;

public class Theme {
    public enum Style {
        PINK("/styles/pink.css"),
        BLUE("/styles/blue.css"),
        LIGHT("/styles/light.css"),
        DARK("/styles/dark.css");

        private final String stylesheet;

        Style(String stylesheet) {
            this.stylesheet = stylesheet;
        }

        public String getStylesheet() {
            return stylesheet;
        }
    }
}
