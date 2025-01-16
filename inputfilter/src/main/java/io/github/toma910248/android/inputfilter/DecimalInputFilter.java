package io.github.toma910248.android.inputfilter;

import static io.github.toma910248.android.inputfilter.utils.RegexHelper.decimalPattern;

public class DecimalInputFilter extends RegexValidation {
    public DecimalInputFilter(int leftOfDecimal, int rightOfDecimal) {
        super(decimalPattern(leftOfDecimal, rightOfDecimal));
    }
}
