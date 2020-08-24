package com.production.masm.Helpers;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String SYMBOLS_FOR_CHECK_PASSWORD = "[!#$:%&*()_+=|<>?{}\\[\\]~]";
    private static final String SYMBOLS_FOR_CHECK_EMAIL_1 = "[!@#$:%&*()+=|<>?{}\\[\\]~]";
    private static final String SYMBOLS_FOR_CHECK_EMAIL_2 = "[0-9]";

    public static boolean isFieldNotValidPassword(String value) {
        Pattern special = Pattern.compile (SYMBOLS_FOR_CHECK_PASSWORD);
        Matcher hasSpecial = special.matcher(value);
        return !(TextUtils.isEmpty(value) || hasSpecial.find());
    }

    public static boolean isFieldNotValidEmail(String value) {
        Pattern digit = Pattern.compile(SYMBOLS_FOR_CHECK_EMAIL_1);
        Pattern special = Pattern.compile (SYMBOLS_FOR_CHECK_EMAIL_2);
        Matcher hasDigit = digit.matcher(value);
        Matcher hasSpecial = special.matcher(value);
        return (TextUtils.isEmpty(value) || hasDigit.find() || hasSpecial.find());
    }
}
