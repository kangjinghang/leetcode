package top.lijngyuan.leetcode.字符串.easy.q58_最后一个单词的长度;
// 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
//       01234 5 678910
// 输出: 5
//
// Related Topics 字符串
// 👍 244 👎 0

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-30
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }

    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ");
        return s.length() - start - 1;
    }

    public static int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

}
