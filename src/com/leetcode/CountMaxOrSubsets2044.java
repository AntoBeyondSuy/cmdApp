package com.leetcode;

/**
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 *
 * 输入：nums = [3,2,1,5]
 * 输出：6
 * 解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 *
 * 解法: 深度优先搜索, 可以理解为一个二叉树, root是不选择任何数(空集), 第一层是"选择第一个数"和"不选第一个数", 依次类推
 *         null
 *     +----+------+
 *     3           0
 *   +-+-+       +-+-+
 * 3,1  3,0    0,1  0,0
 * 每次需要判断:
 * 1> 当前的按位或的值是否==max, 若是则说明此时为一个符合的子集; 可以进行剪枝, 详见 dfs() 函数
 * 2> 当前遍历的数字的index是否为最后一个数字, 若是则说明当前的子集不符合条件(即不是按位或的最大值), 返回0; 因为若是最大值, 已经在 1> 中返回了.
 *
 */
public class CountMaxOrSubsets2044 {

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int n : nums) {  // 得到按位或能取得的最大值
            max |= n;
        }

        return dfs(0, nums, 0, max);
    }

    private int dfs(int curIndex, int[] nums, int curValue, int max) {
        if (curValue == max) {
            /*
                假设到达某一个index的时候此时curValue==max了，但是此时nums.length - index == 8，
                说明此时这1条dfs路径能和后面8个元素的随机组合成符合题目条件的子集。
                可以把后面的8个元素的随机组合看成00000000-11111111，0代表不选，1代表选择，
                因此就是2的8次方。所以可以通过1 << (nums.length - index)来提前剪枝.
             */
            return 1 << (nums.length - curIndex);
        }
        if (curIndex == nums.length) {
            return 0;
        }

        int calOrCur = dfs(curIndex + 1, nums, curValue | nums[curIndex], max);

        int notCalOrCur = dfs(curIndex + 1, nums, curValue, max);

        return calOrCur + notCalOrCur;
    }

}
