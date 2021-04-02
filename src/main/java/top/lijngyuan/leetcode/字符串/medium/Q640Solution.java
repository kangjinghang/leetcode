package top.lijngyuan.leetcode.字符串.medium;
//求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
//
// 如果方程没有解，请返回“No solution”。
//
// 如果方程有无限解，则返回“Infinite solutions”。
//
// 如果方程中只有一个解，要保证返回值 x 是一个整数。
//
// 示例 1：
//
// 输入: "x+5-3+x=6+x-2"
//输出: "x=2"
//
//
// 示例 2:
//
// 输入: "x=x"
//输出: "Infinite solutions"
//
//
// 示例 3:
//
// 输入: "2x=x"
//输出: "x=0"
//
//
// 示例 4:
//
// 输入: "2x+3x-6x=x+2"
//输出: "x=-1"
//
//
// 示例 5:
//
// 输入: "x=x+2"
//输出: "No solution"
//
// Related Topics 数学
// 👍 65 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * q640 solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2021-03-07
 * @since 1.0.0
 */
public class Q640Solution {

    public static void main(String[] args) {
        String equation = "x+5-3+x=6+x-2";
        System.out.println(solveEquation(equation));
    }

    public static String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9') {
            return x.replace("x", "");
        }
        return x.replace("x", "1");
    }

    public static String solveEquation(String equation) {
        // 首先使用 = 将方程左右两边拆分开，然后使用方法 breakIt 分别遍历方程的左右两边，解析出其中的数字和 x，并将结果以数组的形式返回。
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x : breakIt(lr[0])) {
            if (x.indexOf("x") >= 0) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x : breakIt(lr[1])) {
            if (x.indexOf("x") >= 0) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            if (rhs == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + rhs / lhs;

    }

    public static List<String> breakIt(String s) {
        List<String> res = new ArrayList<>();
        // 累积多位字符的字符串，如123
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0) {
                    res.add(r);
                }
                r = "" + s.charAt(i);
            } else {
                r += s.charAt(i);
            }
        }
        res.add(r);
        System.out.println(res);
        return res;
    }

}
