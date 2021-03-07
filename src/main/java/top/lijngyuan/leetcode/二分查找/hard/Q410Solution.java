package top.lijngyuan.leetcode.二分查找.hard;
//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。
//
//
//
// 示例 1：
//
//
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
//
//
// 示例 3：
//
//
//输入：nums = [1,4,4], m = 3
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= m <= min(50, nums.length)
//
// Related Topics 二分查找 动态规划
// 👍 440 👎 0

/**
 * q410 solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-03-07
 * @since 1.0.0
 */
public class Q410Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 2));
        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(splitArray(nums, 2));
        nums = new int[]{1, 4, 4};
        System.out.println(splitArray(nums, 3));
    }

    public static int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int low = max;
        int high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int pieces = split(nums, mid);
            if (pieces > m) {
                // 多切了几刀，那就向后移动一下，再找找比它大的
                low = mid + 1;
            } else {
                // 否则的话，mid可能就是我们想要的值，或者比我们想要的值要大。所以要把high置成mid，再去新的循环，找到真正的正好的我们想要的值
                high = mid;
            }
        }
        return low;
    }

    /**
     * 贪心地模拟分割的过程，从前到后遍历数组，用 sum 表示"当前"分割子数组的和，pieces 表示已经分割出的子数组的数量（包括当前子数组），
     * 一刀一刀的切数组。返回的就是我们要满足一种切割方案，这个方案最大分割子数组和不超过largestNum，这时我们最少能有多少个子数组
     */
    private static int split(int[] nums, int largestNum) {
        // 最少的情况，就是一刀也不切，返回1份子数组（就是本身）
        int pieces = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > largestNum) {
                // 当 sum 加上当前值 num 超过了 largestNum，我们就把当前取的值作为新的一段分割子数组的开头，并将 pieces 加 1
                // 我们必须在这里切上一刀，切了这一刀以后，这一刀后面的新的子数组就要从头开始判断sum，这个"头"就是当前值 num，因此 sum = num
                // 总之就是，每段子数组的最大值，都不能超过largestNum，超过了就要在这里切上一刀
                pieces++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return pieces;
    }

}
