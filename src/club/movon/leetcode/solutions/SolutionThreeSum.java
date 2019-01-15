package club.movon.leetcode.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author zhangzhipeng
 * @date 2019-01-14
 */

public class SolutionThreeSum {
    
    
    /**
     * 思路：
     * 1.排序
     * 2.从左往右依次计算 twoSum答案，如果当前元素与前一个元素相同则跳过
     * <p>
     * 排序可以保证：
     * 1.排序之后 相同元素跳过，不会返回重复的答案
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            
        }
    }
    
    public List<List<Integer>> twoSumHashOnce(int[] nums, int target, int start, int end) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = start; i < nums.length; i++) {
            if (i > 0) {
                int[] n = getIndex(nums, target, map, i);
                if (n != null) {
                    return n;
                }
            }
            map.put(nums[i], i);
            
        }
        
        
    }
    
    private int[] getIndex(int[] nums, int target, Map<Integer, Integer> map, int i) {
        int result = target - nums[i];
        Integer n = map.get(result);
        if (n != null && n != i) {
            return new int[]{n, i};
        }
        return null;
    }
    
    void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }
}
