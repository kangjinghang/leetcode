package top.lijngyuan.leetcode.字符串.easy.q125_验证回文串;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 273 👎 0

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-17
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome1(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        char[] c = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (c[l] != c[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (isNotCharOrNumber(c[l])) {
                l++;
                continue;
            }
            if (isNotCharOrNumber(c[r])) {
                r--;
                continue;
            }
            if (c[l] != c[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean isNotCharOrNumber(char c) {
        return (c < '0' || c > '9') && (c < 'a' || c > 'z');
    }

}
