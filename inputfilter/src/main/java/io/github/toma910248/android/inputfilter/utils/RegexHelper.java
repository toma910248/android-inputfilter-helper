package io.github.toma910248.android.inputfilter.utils;

import android.annotation.SuppressLint;

public class RegexHelper {

    @SuppressLint("DefaultLocale")
    public static String decimalPattern(int leftOfDecimal, int rightOfDecimal) {
        String regex = String.format("\\d{0,%d}", leftOfDecimal);
        if (rightOfDecimal > 0) {
            regex += String.format("(\\.\\d{0,%d})?", rightOfDecimal);
        }
        return regex;
    }
}
