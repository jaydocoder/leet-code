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

    public static void main(String[] args) {

            Random random = new Random();
            int number = random.nextInt(5)+1;

            int [] height =new int [number];
            for(int i=0;i<number;i++){
                height[i]=random.nextInt(50)+1;
            }
            System.out.println(Arrays.toString(height));
            System.out.println(trap(height));
    }
}
