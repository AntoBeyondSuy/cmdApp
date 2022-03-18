package com.demo;

public class GetDuplication {
    /**
     * 面试题3
     * [二分查找思路]不使用辅助空间, 空间复杂度为O(1), 时间复杂度为O(nlogn)
     * key:0,1,2,3,4,5,6,7; value:3,3,1,2,5,6,7,1; length:8
     * 先看 1,2,3,4,5,6,7,8 的前半部分 1,2,3,4: 数组中出现了几次 1,2,3,4? 出现了5次,
     * 若 1,2,3,4 这四个数字无重复则其出现次数之和应该小于等于4, 但现在 5>4, 故数组中必然有 1,2,3,4 中的某一个数字重复出现
     * 再看 1,2,3,4 的前半部分 1,2: 数组中出现了几次 1,2? 3次, 3>2, 故数组中必然有 1,2 中的某一个数字重复出现
     * 再看 1,2 的前半部分 1: 数组中出现了几次 1? 2次, 那就是他了!
     * [!]这种方法并不能找出所有的重复数字, 如 3 也是重复的, 但用本方法不能输出3.
     */
    public void runTest() {
        // numbers = {1,2,3,6,4,5,1,1} {3,3,3,4,4,4,7,1} {3,2,1} {}
        // answers = {1} {3,4} {-1} {-1}
        int[] numbers1 = {1,2,3,6,4,5,1,1};
        int[] answers1 = {1};
        int[] numbers2 = {3,3,3,4,4,4,7,1};
        int[] answers2 = {3,4};
        int[] numbers3 = {3,2,1};
        int[] answers3 = {-1};
        int[] numbers4 = {};
        int[] answers4 = {-1};
        test(numbers1, answers1);
        test(numbers2, answers2);
        test(numbers3, answers3);
        test(numbers4, answers4);
    }

    void test(int[] numbers, int[] answers) {
        int ans = getDuplication(numbers, numbers.length);
        System.out.println(ans);
        for (int answer : answers) {
            if (ans == answer) {
                System.out.println("right answer");
                return;
            }
        }
        System.err.println("!!! WRONG answer !!!");
    }

    int getDuplication(int[] numbers, int length) {
        if (length <= 0 || numbers == null) return -1;
        int start = 0, end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, start, middle);
            if (end == start) {
                if (count > 1) return start;
                else break;
            }

            if (count > (middle - start + 1)) {
                // repeated number in first half
                end = middle;
            } else {
                // repeated number in second half
                start = middle + 1;
            }
        }
        return -1;
    }

    // count how many times the part(start to end) numbers' appears
    static int countRange(int[] numbers, int start, int end) {
        if (numbers == null) return 0;
        int count = 0;
        for (int num : numbers) {
            if (num >= start && num <= end) count++;
        }
        return count;
    }
}
