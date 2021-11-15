package com.lp.leetcode.stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode394 {

    @Test
    public void test() {
        String s = "x2[2[ab]c]";
        System.out.println(decodeString(s));
    }

    // qwe10[ab]
    public String decodeString(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals(']')) {

                LinkedList<Character> part = new LinkedList<>();
                LinkedList<Character> partNum = new LinkedList<>();
                int flat = 1;
                while (true) {
                    if (list.size() == 0) {
                        break;
                    }
                    char xx = list.getFirst();
                    if ('a' <= xx && xx <= 'z') {
                        if (flat == 2) {
                            break;
                        }
                        part.addLast(xx);
                    } else if ('0' <= xx && xx <= '9') {
                        flat = 2;
                        partNum.addLast(xx);
                    } else if (xx == '[' && flat == 2) {
                        break;
                    }
                    list.removeFirst();
                }

                List<Character> partArray = new ArrayList<>();
                while (part.size() > 0) {
                    partArray.add(part.getLast());
                    part.removeLast();
                }

                StringBuilder numSb = new StringBuilder();
                while (partNum.size() > 0) {
                    numSb.append(partNum.getLast());
                    partNum.removeLast();
                }
                int count = Integer.parseInt(numSb.toString());

                for (int forCount = 0; forCount < count; forCount++) {
                    for (int fuckYou = 0; fuckYou < partArray.size(); fuckYou++) {
                        list.addFirst(partArray.get(fuckYou));
                    }
                }

            } else {
                list.addFirst(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (list.size() > 0) {
            result.append(list.getLast());
            list.removeLast();
        }
        return result.toString();
    }
}
