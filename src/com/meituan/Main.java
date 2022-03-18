package com.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        int c = sc.nextInt();
//        int d = sc.nextInt();
        int[][] intervals = {{1,3},{8,10},{2,4},{15,18}};
        Arrays.sort(intervals,(a, b)-> a[0]-b[0]);
        for(int[] itv : intervals) {
            System.out.println(itv[0] + "," + itv[1]);
        }
    }

}
