package com.jay.code.hot438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.jay.code.hot438
 * Description:
 *
 * @Author yijie1
 * @Create 2025/12/18  10:17
 * @Version 1.0
 */
public class Solution {
    // 核心算法方法
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 边界条件判断
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }

        // 统计字符串 p 中字符出现的频次
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 记录当前滑动窗口中字符出现的频次
        int[] windowCount = new int[26];
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            // 右边界字符进入窗口
            windowCount[s.charAt(right) - 'a']++;

            // 当窗口大小等于 p 的长度时，开始判断并尝试收缩左边界
            if (right - left + 1 == p.length()) {
                // 比较窗口内的字符频次是否与 p 一致
                if (Arrays.equals(windowCount, pCount)) {
                    res.add(left);
                }

                // 左边界字符移出窗口
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }
}
