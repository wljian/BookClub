package com.person.prime;

import static com.person.common.CommonUtils.calculateExecuteTime;

public class IsPrimeCase1 {

    public static void main(String[] args) {
        int n = 1000000;

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= n; i++) {
            isPrime(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("總共花費：%.3f秒\n", calculateExecuteTime(startTime, endTime));
    }

    private static boolean isPrime(int number) {
        boolean result = true;

        if (number <= 1) {
            result = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
