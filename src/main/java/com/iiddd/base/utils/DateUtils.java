package com.iiddd.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getCurrentDateAsString() {
        return new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date());
    }
}
