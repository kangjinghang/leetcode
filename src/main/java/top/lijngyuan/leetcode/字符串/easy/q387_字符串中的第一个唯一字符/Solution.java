package top.lijngyuan.leetcode.字符串.easy.q387_字符串中的第一个唯一字符;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 266 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-14
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));

        s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> count = new HashMap<>(chars.length);
        for (char c : chars) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (count.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 记录每个字母的最后一次出现的所在索引
            arr[c - 'a'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 比较各个字母第一次出现的索引是否为最后一次的索引。
            // 如果是，我们就找到了我们的目标，
            // 如果不是我们将其设为 -1（标示该元素非目标元素）如果第二次遍历最终没有找到目标，直接返回 -1即可。
            if (i == arr[c - 'a']) {
                return i;
            } else {
                // 避免如 ['c','c'] 这种情况
                arr[c - 'a'] = -1;
            }
        }
        return -1;
    }

    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 记录每个字母的出现的次数
            count[c - 'a'] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (count[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
