package top.lijngyuan.leetcode.栈.easy.q20_有效的括号;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1771 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-08-14
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        String str = "()";
        System.out.println(isValid(str)); // true
        str = "()[]{}";
        System.out.println(isValid(str)); // true
        str = "(]";
        System.out.println(isValid(str)); // false
        str = "([)]";
        System.out.println(isValid(str)); // false
        str = "{[]}";
        System.out.println(isValid(str)); // true
    }

    public static Map<Character, Character> DICT = new HashMap<>();

    static {
        DICT.put(')' , '(');
        DICT.put(']' , '[');
        DICT.put('}' , '{');
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (DICT.containsKey(c)) {
                if (stack.isEmpty() || !DICT.get(c).equals(stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
