package com.bytedance;

import java.util.Arrays;
import java.util.HashMap;

/**
 * M 只猫, 能力值分别为 a_i, 祭坛 E 每轮进攻都可以为任意一只猫提供任意的能力值加成, 但仅限本轮进攻
 * N 条狗, 攻击力 b_i, 防御力 c_i
 * 狗狗阵营开展N轮攻击, 第 n 轮派出第 n 条狗,
 * 猫猫阵营迎战, 派出一条 能力值大于等于该狗的防御力 的猫猫才行. 剩余猫猫的能力值之和需要大于等于该狗的攻击力.
 * 祭坛可以在派出猫猫前为任意一只猫提供任意的能力值加成, 问每轮进攻祭坛需要分配的最小能力值.
 */
public class CatDogDefense {
    public int[] catDefenseDog(int M, int N, int[] cats, int[][] dogs) {
        // 对猫猫能力值排序
        Arrays.sort(cats);
        HashMap<Integer, int[]> catsNeighborMap = new HashMap<>();
        int allSum = 0;

        for (int i = 0; i < cats.length - 1; i++) {
            // 小于 等于 大于
            catsNeighborMap.put(i, new int[]{i - 1, i, i + 1});
            allSum += cats[i];
        }
        allSum += cats[cats.length-1];  // 猫猫的能力值之和
        catsNeighborMap.put(cats.length - 1, new int[]{cats.length - 2, cats.length - 1, -1});

        for (int[] dog : dogs) {
            int smallerIndex, equalIndex, biggerIndex;
            int othersSum;
            if (catsNeighborMap.containsKey(dog[1])) {
                equalIndex = catsNeighborMap.get(dog[1])[1];
//                othersSum = allSum - ;
            }
            // 获取能力值距离狗狗防御值最近的猫猫的编号: 小于, 等于, 大于
            int[] candidateCats = selectCandidates(cats, dog[1]);
        }


        return null;
    }

    private int[] selectCandidates(int[] cats, int dogDefense) {

        return new int[0];
    }

    void test() {
        int M = 5;
        int N = 5;
        int[] cat = new int[]{4, 2, 3, 2, 5};  // int[M]
        int[][] dog = new int[][]{{2, 9}, {6, 8}, {1, 5}, {3, 50}, {30, 4}, {60, 66}};  // int[N][2]
        int[] ans = new int[]{0, 1, 0, 37, 25, 55};
        catDefenseDog(M, N, cat, dog);


    }
}
