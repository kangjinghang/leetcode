package top.lijngyuan.leetcode.滑动窗口.hard.q239_滑动窗口最大值;
//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 619 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2020-11-11
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    /**
     * 双向队列
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // 双端队列，就是两边都可以插入和删除数据的队列，注意这里存储的是元素在数组中的下标，不是元素的值
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 首先清理队列
            // 1. 只保留当前滑动窗口中有的元素的索引
            // 如果队列中队头元素和当前元素位置相差i-k，相当于队头元素要出窗口了，就把队头元素给移除，注意队列中存储
            // 的是元素的下标（函数peekFirst()表示的是获取队头的下标，函数pollFirst()表示的是移除队头元素的下标）
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 2. 移除比当前元素小的所有元素，它们不可能是最大的
            // 在添加一个值之前，前面比他小的都要被移除掉，并且还要保证窗口中队列头部元素永远是队列中最大的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 当前元素的下标加入到队列的尾部，即将当前元素添加到双向队列中
            deque.addLast(i);
            // 当窗口的长度大于等于k个的时候才开始计算（注意这里的i是从0开始的）,刚开始窗口还比较小，不用加入结果集
            if (i >= k - 1) {
                // 队头元素是队列中最大的，把队列头部的元素加入到数组中
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    /**
     * 暴力解法
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        // L-k+1 个窗口
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < arr.length; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            arr[i] = max;
        }
        return arr;
    }

}
