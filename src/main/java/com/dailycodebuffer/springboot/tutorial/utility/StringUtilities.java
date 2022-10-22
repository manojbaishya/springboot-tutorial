package com.dailycodebuffer.springboot.tutorial.utility;

public class StringUtilities {
    private StringUtilities() {
    }

    public static boolean isNullOrEmpty(String checkString) {
        return checkString == null || checkString.isBlank();
    }
}
