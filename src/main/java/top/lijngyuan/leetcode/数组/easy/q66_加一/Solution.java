package top.lijngyuan.leetcode.数组.easy.q66_加一;
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组
// 👍 529 👎 0

import java.util.Arrays;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-08-28
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits)));
        int[] digits1 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(digits1)));
        int[] digits2 = {4, 3, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits2)));
        int[] digits3 = {9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits3)));
        int[] digits4 = {8, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits4)));
    }

    public static int[] plusOne2(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] != 9) {
            digits[length - 1] += 1;
        } else { // 需要进位
            int index = length - 1;
            while (index > 0 && digits[index] == 9) {
                digits[index] = 0;
                index--;
            }
            // 需要进位的不是首位（4, 3, 9, 9），或者首位不需要进位（8, 9, 9, 9）
            if (index != 0 || digits[index] != 9) {
                digits[index] += 1;
            } else {
                // 首位也需要进位
                int[] dest = new int[digits.length + 1];
                // int数组默认都是0，不需要拷贝数组了
                // System.arraycopy(digits, 1, dest, 0, digits.length - 1);
                dest[0] = 1;
                return dest;
            }
        }
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
