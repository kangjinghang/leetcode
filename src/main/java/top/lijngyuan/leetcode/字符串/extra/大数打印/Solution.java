package top.lijngyuan.leetcode.字符串.extra.大数打印;
// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
//
//
// 示例1：
// 输入: n = 1
// 输出: [1,2,3,4,5,6,7,8,9]
//
// 说明：
//
// 用返回一个整数列表来代替打印
// n 为正整数

import java.util.Arrays;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-17
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] numbers = printNumbers(3);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static int[] printNumbers1(int n) {
        int len = (int) Math.pow(10, n);
        int[] res = new int[len - 1];
        for (int i = 1; i < len; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static int[] printNumbers(int n) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            len = len * 10 + 9;
        }
        int[] res = new int[len];
        for (int i = 1; i <= len; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void realPrintNumbers(int n) {
        //声明字符数组,用来存放一个大数
        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!incrementNumber(number)) {
            // 存储数值
            saveNumber(number);
        }
    }

    private static boolean incrementNumber(char[] number) {
        //循环体退出标识
        boolean isBreak = false;
        int carry = 0;
        int len = number.length;
        for (int i = len - 1; i >= 0; i--) {
            // 取第i位的数字转化位int
            int nSum = number[i] - '0' + carry;
            if (i == len - 1) {
                // 最低位加1
                ++nSum;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isBreak = true;
                } else {
                    // 进位之后减10，并把进位标识设置为1
                    nSum -= 10;
                    carry = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isBreak;
    }

    private static void saveNumber(char[] number) {
        boolean isBegin0 = true;
        for (char c : number) {
            if (isBegin0) {

            }
        }
    }

}
