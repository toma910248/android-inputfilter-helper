package io.github.toma910248.android.inputfilter.utils;

import static org.junit.Assert.assertEquals;
import static io.github.toma910248.android.inputfilter.utils.InputFilterUtils.getNewText;

import org.junit.Test;

public class InputFilterUtilsTest {

    @Test
    public void testGetNewText() {
        assertEquals("When append '5'", "12345", getNewText("5", 0, 1, "1234", 4, 4));
        assertEquals("When insert '4' between '3' and '5'", "12345", getNewText("4", 0, 1, "1235", 3, 3));
        assertEquals("When paste '4' between '3' and '5'", "12345", getNewText("34", 0, 2, "125", 2, 2));
        assertEquals("When delete '4'", "1235", getNewText("", 0, 0, "12345", 3, 4));
        assertEquals("When cut '34'", "125", getNewText("", 0, 0, "12345", 2, 4));
    }
}