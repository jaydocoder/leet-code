package com.jay.code.hot239;

import java.util.Arrays;

/**
 * ClassName: SolutionTest
 * Package: com.jay.code.hot239
 * Description:
 *
 * @Author yijie1
 * @Create 2026/1/3  13:33
 * @Version 1.0
 */
public class SolutionTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow2(nums, 2);
        System.out.println(Arrays.toString(result));
    }
}
