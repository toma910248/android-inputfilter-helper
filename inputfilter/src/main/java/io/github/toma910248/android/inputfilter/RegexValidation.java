package io.github.toma910248.android.inputfilter;

public class RegexValidation extends ValidationInputFilter {
    private final String regex;

    public RegexValidation(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean validate(CharSequence newText, CharSequence oldText) {
        return newText.toString().matches(regex);
    }
}
