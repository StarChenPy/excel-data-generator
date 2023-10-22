package xyz.starsdust.exceldatagenerator.util.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum LogLevel {
    ERROR,
    INFO,
    WARN;

    public String parserLogInfo(String info) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return "[" + sdf.format(date) + "] [" + this + "] " + info;
    }
}
