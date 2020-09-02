package top.lijngyuan.leetcode.数组.medium.q11_盛最多水的容器;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例：
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49
// Related Topics 数组 双指针
// 👍 1787 👎 0

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-09-02
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        // 49
        System.out.println(maxArea(height));
    }

    /**
     * 双指针法
     * <p>
     * 水量 = 两个指针指向的数字中较小值 ∗ 指针之间的距离
     * 如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，
     * 后者「指针之间的距离」会减小，那么这个乘积会减小。因此，我们移动数字较大的那个指针是不合理的。因此，我们移动 数字较小的那个指针。
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                maxArea = Math.max(maxArea, (r - l) * height[l]);
                l++;
            } else {
                maxArea = Math.max(maxArea, (r - l) * height[r]);
                r--;
            }
        }
        return maxArea;
    }

    /**
     * 暴力解法
     */
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }

}
