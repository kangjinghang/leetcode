package top.lijngyuan.leetcode.字符串.easy.q796_旋转字符串;
//给定两个字符串, A 和 B。
//
// A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
//，A 能变成B，那么返回True。
//
//
//示例 1:
//输入: A = 'abcde', B = 'cdeab'
//输出: true
//
//示例 2:
//输入: A = 'abcde', B = 'abced'
//输出: false
//
// 注意：
//
//
// A 和 B 长度不超过 100。
//
// 👍 100 👎 0

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-27
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        String A = "abcde";
        String B = "cdeab";
        System.out.println(rotateString(A, B));
        A = "abcde";
        B = "abced";
        System.out.println(rotateString(A, B));
        A = "abcde";
        B = "abcde";
        System.out.println(rotateString(A, B));
        A = "";
        B = "";
        System.out.println(rotateString(A, B));
    }

    public static boolean rotateString(String A, String B) {
        boolean contains = isSubString(A + A, B);
        return A.length() == B.length() && contains;
    }

    public static boolean isSubString(String str, String sub) {
        if (str.equals(sub)) {
            return true;
        }
        int[] next = kmpNext(sub);
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != sub.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == sub.charAt(j)) {
                j++;
            }
            if (j == sub.length()) {
                return true;
            }
        }
        return false;
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * 无论它怎样旋转，最终的 A + A包含了所有可以通过旋转操作从 A 得到的字符串
     * A + A 作为全集，包括了所有可能的情况
     */
    public static boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static boolean rotateString1(String A, String B) {
        if (null == A || null == B) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }
        int len = A.length();
        for (int i = 1; i < len; i++) {
            String tempA = A.substring(i + 1).concat(A.substring(0, i + 1));
            if (tempA.equals(B)) {
                return true;
            }
        }
        return false;
    }

}
