package top.lijngyuan.leetcode.滑动窗口.medium.q3_无重复字符的最长子串;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
//请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4574 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2020-11-12
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring1(" "));
    }

    /**
     * 滑动窗口-双指针 时间复杂度O(2N)，前后指针都要遍历
     */
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        // right 滑动窗口右指针， left 窗口左指针 abcabcbb 窗口，a[bca]bcbb ，left = 1 right = 4
        int result = 0, left = 0, right = 0;
        int n = s.length();
        while (left < n && right < n) {
            if (set.contains(s.charAt(right))) {
                // 窗口内已经存在时，出现过的元素以及其左边的元素通通移除
                // 每一次循环移除一位，从最左边开始移除
                // 下一次循环，能进入到这个分支，移除的变成了最左边第二位，直到完全移除干净为止（出现过的元素以及其左边的元素通通移除，不再进入此循环）
                set.remove(s.charAt(left));
                // 左指针向前移动
                left++;
            } else {
                set.add(s.charAt(right));
                // 右指针向前移动
                right++;
                result = Math.max(result, right - left);
            }
        }
        return result;
    }

    /**
     * 滑动窗口-双指针+哈希表 时间复杂度O(N)
     */
    public static int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int n = s.length();
        // 字符和索引位置的映射，value存的是右指针的自然数位置，因为要求返回几个共同字符
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0, left = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right))) {
                // 找到重复的字符时，我们可以立即跳过该窗口
                left = Math.max(map.get(s.charAt(right)), left);
            }
            map.put(s.charAt(right), right + 1);
            result = Math.max(right - left + 1, result);
        }
        return result;
    }

    /**
     * 滑动窗口-双指针+数组 时间复杂度O(N)
     */
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = s.length();
        // 字符和索引位置的映射，value存的是右指针的自然数位置，因为要求返回几个共同字符
        int[] index = new int[256];

        for (int right = 0, left = 0; right < n; right++) {
            if (index[s.charAt(right)] != 0) {
                // 找到重复的字符时，我们可以立即跳过该窗口
                left = Math.max(index[s.charAt(right)], left);
            }
            index[s.charAt(right)] = right + 1;
            result = Math.max(right - left + 1, result);
        }
        return result;
    }

}
