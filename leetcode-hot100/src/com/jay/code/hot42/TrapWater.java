package com.jay.code.hot42;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: TrapWater
 * Package: com.jay.code.hot42
 * Description:
 *
 * @Author yijie1
 * @Create 2025/12/15  13:49
 * @Version 1.0
 */
public class TrapWater {
    //采用动态规划的方法来完成这个题目
    public static int trap(int[] height) {
        int n = height.length;
        if(height==null||n==0)return 0;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
    //采用双指针来解决这个问题
    public static int trap2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
