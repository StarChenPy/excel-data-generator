package xyz.starsdust.exceldatagenerator.util.log;

import java.util.ArrayList;
import java.util.List;

public class MyLog {
    private static final List<LogListener> listeners;

    static {
        listeners = new ArrayList<>();
        listeners.add(System.out::println);
    }

    public static void addLogListener(LogListener listener) {
        listeners.add(listener);
    }

    public static void warn(String info) {
        log(info, LogLevel.WARN);
    }

    public static void info(String info) {
        log(info, LogLevel.INFO);
    }

    public static void err(String info) {
        log(info, LogLevel.ERROR);
    }

    private static void log(String info, LogLevel level) {
        String logInfo = level.parserLogInfo(info);
        executeListener(logInfo);
    }

    private static void executeListener(String info) {
        for (LogListener listener : listeners) {
            listener.execute(info);
        }
    }
}
