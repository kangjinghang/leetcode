package top.lijngyuan.leetcode.字符串.easy.q14_最长公共字符串;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1214 👎 0

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-08-14
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);

        strs = new String[]{"dog", "racecar", "car"};
        prefix = longestCommonPrefix(strs);
        System.out.println(prefix);

        strs = new String[]{"a"};
        prefix = longestCommonPrefix(strs);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if ("".equals(prefix)) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
