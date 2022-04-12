package com.person.prime;

import java.util.Arrays;

import static com.person.common.CommonUtils.calculateExecuteTime;

public class PrimeTable {

    private int n;
    private boolean[] primeTable;

    public PrimeTable(int n) {
        this.n = n;
        this.primeTable = new boolean[n + 1];

        long startTime = System.currentTimeMillis();
        this.createPrimeTable(); // 建立 1 ~ n 的質數表
        long endTime = System.currentTimeMillis();

        System.out.printf("質數表建立完成，總共花費：%.3f秒\n", calculateExecuteTime(startTime, endTime));
    }

    private void createPrimeTable() {
        Arrays.fill(this.primeTable, true); // 設定陣列中所有元素的值為true
        int sqrtN = (int) Math.sqrt(this.n);

        this.primeTable[0] = false; // 不是質數
        this.primeTable[1] = false; // 不是質數

        for (int i = 2; i < sqrtN; i++) {
            for (int j = i * 2; j <= this.n; j += i) {
                this.primeTable[j] = false;
            }
        }
    }

    public boolean isPrime(int number) {
        if (number > this.n) {
            throw new RuntimeException("超出質數表最大的數。");
        } else if (number < 0) {
            return false;
        }

        return this.primeTable[number];
    }
}
