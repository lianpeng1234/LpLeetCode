package com.lp.leetcode.other;

import org.junit.Test;

import java.util.*;

// 剑指 Offer 38. 字符串的排列
public class LeetCodeSwordOffer38 {

    @Test
    public void test() {
        String[] str = permutation("abc");
        System.out.println(Arrays.toString(str));
    }

    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        Set<String> strSet = new HashSet<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            String sb = "";
            Set<Integer> set = new HashSet<>();
            recursion(set, sb, ch, i, list, strSet);
        }
        return list.toArray(new String[]{});
    }

    private void recursion(Set<Integer> set, String sb, char[] ch, int index, List<String> list, Set<String> strSet) {
        sb = sb + ch[index];
        set.add(index);

        if (sb.length() >= ch.length && !strSet.contains(sb)) {
            list.add(sb);
            strSet.add(sb);
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            if (!set.contains(i)) {
                recursion(set, sb, ch, i, list, strSet);
                set.remove(i);
            }
        }
    }

}
