package com.jay.code.hot523;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Package: com.jay.code.hot523
 * Description:
 *
 * @Author yijie1
 * @Create 2025/12/30  19:34
 * @Version 1.0
 */
public class Solution {
    //解法一：暴力法
    public boolean checkSubarraySum1(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        for (int i = 0; i < n  ; i++) {
            int sum = 0;
            for (int j = i; j < n ; j++) {
                sum += nums[j];
                if (sum % k == 0&&j-i>=1) {
                    return true;
                }
            }
        }
        return false;
    }
    //解法二：前缀和+哈希表
    public boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

}
