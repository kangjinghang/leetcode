package top.lijngyuan.leetcode.动态规划.easy.easy.q53_最大子序和;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2410 👎 0

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-11
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }


    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum;
                if ((sum = sum(nums, i, j)) > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int sum(int[] nums, int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
