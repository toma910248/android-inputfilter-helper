package io.github.toma910248.android.inputfilter.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static io.github.toma910248.android.inputfilter.utils.RegexHelper.decimalPattern;

import org.junit.Test;

public class RegexHelperTest {

    @Test
    public void testDecimalPattern() {
        assertTrue("1".matches(decimalPattern(1, 0)));
        assertTrue("1".matches(decimalPattern(2, 0)));
        assertTrue("12".matches(decimalPattern(2, 0)));
        assertTrue("1".matches(decimalPattern(3, 0)));
        assertTrue("12".matches(decimalPattern(3, 0)));
        assertTrue("123".matches(decimalPattern(3, 0)));
        assertTrue("1".matches(decimalPattern(1, 1)));
        assertTrue("1.2".matches(decimalPattern(1, 1)));
        assertTrue("1".matches(decimalPattern(1, 2)));
        assertTrue("1.2".matches(decimalPattern(1, 2)));
        assertTrue("1.23".matches(decimalPattern(1, 2)));
        assertTrue("1.".matches(decimalPattern(1, 2)));

        assertFalse("12".matches(decimalPattern(1, 0)));
        assertFalse("1.".matches(decimalPattern(1, 0)));
        assertFalse("1.2".matches(decimalPattern(1, 0)));
        assertFalse("1.23".matches(decimalPattern(1, 1)));
    }
}