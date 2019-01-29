package club.movon.leetcode.solutions;

import java.util.Comparator;
import java.util.List;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author zhangzhipeng
 * @date 2019-01-25
 */
public class SolutionMaximumSubarray {
    
    /**
     * 分治法
     * 分析结果：
     * 1. 最大子序列全部在数组左侧
     * 2. 最大子序列全部在数组右侧
     * 3. 最大子序列垮过中线
     * 假设结果序列为[Ai...Aj]，nums二分点下标为m
     * <p>
     * 对于前两种情况可以使用递归求解
     * find(0,m)
     * find(m+1,len)
     * 对于第三种情况，我们只需要从i开始向左查找最大串，并且从j开始查找最大串
     * 两者的和就是我们要的结果
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
    
    private int find(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        
        if (left == right) {
            return nums[left];
        }
        
        int m = (left + right) / 2;
        int max1 = find(nums, left, m);
        int max2 = find(nums, m + 1, right);
        
        int maxl = nums[m];
        int p = m - 1;
        int maxCurrent = maxl;
        while (p >= left) {
            maxCurrent += nums[p--];
            if (maxCurrent > maxl) {
                maxl = maxCurrent;
            }
        }
        
        
        int maxr = nums[m + 1];
        p = m + 2;
        maxCurrent = maxr;
        while (p <= right) {
            maxCurrent += nums[p++];
            if (maxCurrent > maxr) {
                maxr = maxCurrent;
            }
        }
        return Math.max(maxl + maxr, Math.max(max1, max2));
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        SolutionMaximumSubarray solution = new SolutionMaximumSubarray();
        System.out.println(solution.maxSubArray(nums));
        
    }
}
