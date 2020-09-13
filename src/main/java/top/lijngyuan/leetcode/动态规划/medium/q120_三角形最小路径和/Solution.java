package top.lijngyuan.leetcode.动态规划.medium.q120_三角形最小路径和;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划
// 👍 591 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-13
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int size = triangle.size();

        // [2]
        // [3,4]
        // [6,5,7]
        // [4,1,8,3]

        // dp[i][j] : 表示包含第i行j列元素的最小路径和
        int[][] dp = new int[size][triangle.get(size - 1).size()];
        // 第一行特殊处理，无论最后的路径是哪一条，它一定要经过最顶上的元素，即 [0,0]。所以我们需要对 dp[0][0] 进行初始化。
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            // 遍历每一行
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    // 最左边的元素只能从自己头顶而来
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    // 最右边的元素只能从自己左上角而来
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        // 只要找到最后一行元素中，路径和最小的一个
        int minTotal = dp[size - 1][dp[size - 1].length - 1];
        for (int i = 0; i < dp[size - 1].length; i++) {
            minTotal = Math.min(dp[size - 1][i], minTotal);
        }
        return minTotal;
    }

    public static int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int size = triangle.size();

        // [2]
        // [3,4]
        // [6,5,7]
        // [4,1,8,3]

        // f[i][j] 只与 f[i-1][..] 有关，而与 f[i-2][..] 及之前的状态无关，
        // 因此我们不必存储这些无关的状态。
        // 具体地，我们使用两个长度为 n 的一维数组进行转移，将 i 根据奇偶性映射到其中一个一维数组，
        // 那么 i−1 就映射到了另一个一维数组。这样我们使用这两个一维数组，交替地进行状态转移。
        int[][] dp = new int[2][size];

        // 第一行特殊处理，无论最后的路径是哪一条，它一定要经过最顶上的元素，即 [0,0]。所以我们需要对 dp[0][0] 进行初始化。
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            int curr = i % 2;
            int prev = 1 - curr;
            dp[curr][0] = dp[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[curr][j] = Math.min(dp[prev][j], dp[prev][j - 1]) + triangle.get(i).get(j);
            }
            dp[curr][i] = dp[prev][i - 1] + triangle.get(i).get(i);
        }
        // 只要找到最后一行元素中，路径和最小的一个
        int minTotal = dp[(size - 1) % 2][0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(dp[(size - 1) % 2][i], minTotal);
        }
        return minTotal;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int size = triangle.size();

        // [2]
        // [3,4]
        // [6,5,7]
        // [4,1,8,3]
        int[] dp = new int[size];

        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }

}
