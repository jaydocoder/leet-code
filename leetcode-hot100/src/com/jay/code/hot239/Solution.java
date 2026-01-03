package com.jay.code.hot239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: Solution
 * Package: com.jay.code.hot239
 * Description:
 *
 * @Author yijie1
 * @Create 2026/1/3  13:32
 * @Version 1.0
 */
public class Solution {
    //采用暴力解法
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n =nums.length;
        if(n==0||k==0){
            return new int[0];
        }
        //定义需要返回的数组
        int [] arr=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            //初始化一个最大值
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(nums[j]>max){
                    max=nums[j];
                }
            }
            arr[i]=max;
        }
        return arr;

    }
    //采用双端队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n =nums.length;
        if(n==0||k==0){
            return new int[0];
        }
        //定义需要返回的结果数组
        int [] result =new int [n-k+1];
        //定义双端队列
        Deque<Integer> deque =new LinkedList<>();


        for (int i = 0; i < n; i++) {
            // 步骤1：移除「滑出窗口」的队头元素（下标 ≤ i - k 说明已不在窗口内）
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 步骤2：维护队列「单调递减」—— 从队尾移除所有比当前元素小的下标
            // 因为这些元素不可能成为后续窗口的最大值，直接淘汰
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 步骤3：将当前元素下标入队（此时队列仍保持单调递减）
            deque.offerLast(i);

            // 步骤4：当窗口形成（i ≥ k-1）时，队头就是当前窗口的最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

}
