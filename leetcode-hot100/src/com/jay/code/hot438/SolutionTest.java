package com.jay.code.hot438;

import java.util.List;

/**
 * ClassName: SolutionTest
 * Package: com.jay.code.hot438
 * Description:
 *
 * @Author yijie1
 * @Create 2025/12/18  10:18
 * @Version 1.0
 */
public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例设计
        System.out.println("--- LeetCode 438 测试开始 ---");

        // Case 1: 标准示例
        printTestResult(solution, "cbaebabacd", "abc", "[0, 6]");

        // Case 2: 连续重复示例
        printTestResult(solution, "abab", "ab", "[0, 1, 2]");

        // Case 3: 无匹配项
        printTestResult(solution, "apple", "z", "[]");

        // Case 4: p 比 s 长（边界情况）
        printTestResult(solution, "abc", "abcdefg", "[]");

        // Case 5: 完全匹配
        printTestResult(solution, "anagram", "anagram", "[0]");

        System.out.println("--- 所有测试完成 ---");
    }
    /**
     * 辅助测试方法，用于格式化输出结果
     */
    private static void printTestResult(Solution sol, String s, String p, String expected) {
        List<Integer> result = sol.findAnagrams(s, p);
        System.out.println("输入: s = \"" + s + "\", p = \"" + p + "\"");
        System.out.println("预期结果: " + expected);
        System.out.println("实际结果: " + result);
        System.out.println(expected.equals(result.toString()) ? "✅ 测试通过" : "❌ 测试失败");
        System.out.println("---------------------------");
    }
}
