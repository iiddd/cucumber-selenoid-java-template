package com.iiddd.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isStringMatchedWithPattern(String compareString, String regularExpression) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(compareString);
        return matcher.find();
    }
}
