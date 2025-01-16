package io.github.toma910248.android.inputfilter;

import android.text.InputFilter;
import android.text.Spanned;

import io.github.toma910248.android.inputfilter.utils.InputFilterUtils;

public abstract class ValidationInputFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (validate(InputFilterUtils.getNewText(source, start, end, dest, dstart, dend), dest)) {
            return null;
        } else {
            return dest.subSequence(dstart, dend);
        }
    }

    public abstract boolean validate(CharSequence newText, CharSequence oldText);
}
