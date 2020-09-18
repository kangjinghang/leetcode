package top.lijngyuan.leetcode.字符串.easy.q344_反转字符串;
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
//
//
//
// 示例 1：
//
// 输入：['h','e','l','l','o']
//输出：['o','l','l','e','h']
//
//
// 示例 2：
//
// 输入：['H','a','n','n','a','h']
//输出：['h','a','n','n','a','H']
// Related Topics 双指针 字符串
// 👍 278 👎 0

import java.util.Arrays;

/**
 * Solution
 *
 * @author <a href='kangjinghang@gmail.com'>kangjinghang</a>
 * @date 2020-09-14
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString1(char[] s) {
        // 定义left和right分别指向首元素和尾元素
        int left = 0;
        int right = s.length - 1;

        // 当left < right ，进行交换。
        // 交换完毕，left++，right--
        // 直至left == right
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 递归
     */
    public static void reverseString(char[] s) {
        // 定义left和right分别指向首元素和尾元素
        int left = 0;
        int right = s.length - 1;
        reverseString(s, left, right);
    }

    public static void reverseString(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
        reverseString(s, left, right);
    }

}
