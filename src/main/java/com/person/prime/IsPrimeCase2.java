package com.person.prime;

import static com.person.common.CommonUtils.calculateExecuteTime;

public class IsPrimeCase2 {

    public static void main(String[] args) {
        int n = 1000000;
        PrimeTable primeTable = new PrimeTable(n);

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= n; i++) {
            primeTable.isPrime(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("總共花費：%.3f秒\n", calculateExecuteTime(startTime, endTime));
    }
}
