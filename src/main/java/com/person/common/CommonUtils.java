package com.person.common;

public class CommonUtils {

    public static double calculateExecuteTime(long startTime, long endTime) {
        long time = endTime - startTime;
        return time / 1000.0;
    }
}
