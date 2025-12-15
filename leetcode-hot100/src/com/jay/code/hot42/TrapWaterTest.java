package com.jay.code.hot42;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: TrapWaterTest
 * Package: com.jay.code.hot42
 * Description:
 *
 * @Author yijie1
 * @Create 2025/12/15  14:51
 * @Version 1.0
 */
public class TrapWaterTest {
    public static void main(String[] args) {
        TrapWater trapWater = new TrapWater();


        Random random = new Random();
        int number = random.nextInt(5)+1;

        int [] height =new int [number];
        for(int i=0;i<number;i++){
            height[i]=random.nextInt(50)+1;
        }
        System.out.println(Arrays.toString(height));
        System.out.println(trapWater.trap(height));
        System.out.println(trapWater.trap2(height));
    }
}
