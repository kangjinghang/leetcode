package top.lijngyuan.leetcode.字符串.easy.q6_Z字行变换;
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
// L   C   I   R
// E T O E S I I G
// E   D   H   N
//
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
// string convert(string s, int numRows);
//
// 示例 1:
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//
//
// 示例 2:
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
// L     D     R
// E   O E   I I
// E C   I H   N
// T     S     G
// Related Topics 字符串
// 👍 811 👎 0

import java.util.Arrays;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-08-31
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println(convert3(s, numRows));
        s = "LEETCODEISHIRING";
        numRows = 4;
        System.out.println(convert3(s, numRows));
//        System.out.println(convert2(s, numRows));
//        s = "LEETCODEISHIRING";
//        numRows = 4;
//        System.out.println(convert2(s, numRows));
//        System.out.println(convert(s, numRows));
//        s = "LEETCODEISHIRING";
//        numRows = 4;
//        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[Math.min(numRows, s.length())];
        Arrays.fill(arr, "");
        int period = numRows * 2 - 2;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int mod = i % period;
            if (mod < numRows) {
                arr[mod] += chars[i];
            } else {
                arr[period - mod] += String.valueOf(chars[i]);
//                arr[period - mod] += chars[i];
            }
        }
        StringBuilder res = new StringBuilder();
        for (String ch : arr) {
            res.append(ch);
        }
        return res.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int period = numRows * 2 - 2;
        int n = s.length();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += period) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + period - i < n) {
                    ret.append(s.charAt(j + period - i));
                }
            }
        }
        return ret.toString();
    }

    public static String convert3(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        int cursor = 0, flag = -1;
        for (char c : s.toCharArray()) {
            arr[cursor] += c;
            if (cursor == 0 || cursor == numRows - 1) {
                flag = -flag;
            }
            cursor += flag;
        }
        StringBuilder res = new StringBuilder();
        for (String ch : arr) {
            res.append(ch);
        }
        return res.toString();
    }

}
