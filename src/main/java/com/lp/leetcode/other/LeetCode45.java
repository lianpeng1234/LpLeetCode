package com.lp.leetcode.other;

public class LeetCode45 {

    public int jump(int[] nums) {
        int length = nums.length;
        int skipCount = 0;
        for (int pos = 0; pos < length; ) {
            // 元素为 0，直接略过
            if (nums[pos] < 1) {
                pos++;
                continue;
            }

            // 当前节点已经是数据末尾
            if (pos >= length - 1) {
                return skipCount;
            }

            // 当前节点，下一跳直接到达数据末尾
            if (nums[pos] + pos >= length - 1) {
                return ++skipCount;
            }

            // 寻找下一跳的位置
            int distance = 0;
            int nextPos = pos;
            for (int j = pos + 1; j <= nums[pos] + pos && j < length; j++) {
                int xx = j - pos + nums[j];
                if (xx >= distance) {
                    nextPos = j;
                    distance = xx;
                }
            }
            pos = nextPos;
            skipCount++;
        }
        return skipCount;
    }
}
