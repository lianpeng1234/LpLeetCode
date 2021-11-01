package com.lp.leetcode.other;

import java.util.*;

public class LeetCode1488 {

    public static void main(String[] args) {
        int[] rains = new int[]{1, 0, 2, 0, 2, 1};
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }

    public static int[] avoidFlood(int[] rains) {
        // 记录水满的胡泊 key 第几个湖泊，value 为湖泊在 rains 数组中的下标
        HashMap<Integer, Integer> rainMap = new HashMap<>();
        // 记录可以抽干湖泊的下标位置，key 为 rains 数组中的下标
        LinkedList<Integer> zero = new LinkedList<>();

        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            int lakes = rains[i];
            if (lakes > 0) {
                if (rainMap.containsKey(lakes)) {
                    if (!zero.isEmpty()) {
                        int lakesIndex = rainMap.get(lakes);// 湖泊下标

                        // 找出距离 lakesIndex 最近的可以抽干湖泊的数组下标
                        Integer xxx = null;
                        Iterator<Integer> it = zero.iterator();
                        while (it.hasNext()) {
                            Integer tmp = it.next();
                            if (tmp > lakesIndex) {
                                xxx = tmp;
                                it.remove();
                                break;
                            }
                        }
                        if (xxx == null) {
                            return new int[]{};
                        }

                        // 抽干胡泊
                        ans[xxx] = lakes;
                        rainMap.remove(lakes);
                    } else {
                        return new int[]{};
                    }
                }
                rainMap.put(lakes, i);
                ans[i] = -1;
            } else {
                zero.addLast(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
