package io.github.toma910248.android.inputfilter.utils;

public class InputFilterUtils {
    public static CharSequence getNewText(CharSequence source, int start, int end, CharSequence dest, int dstart, int dend) {
        CharSequence head = dest.subSequence(0, dstart);
        CharSequence src = source.subSequence(start, end);
        CharSequence tail = dest.subSequence(dend, dest.length());

        return head.toString() + src + tail;
    }
}
