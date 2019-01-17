package club.movon.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            List<List<Integer>> lists = twoSumHashOnce(nums, target, i);
            result.addAll(lists);
        }
        
        Set<String> resultStr = new HashSet<>();
        Iterator<List<Integer>> iterator = result.iterator();
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            next.sort((Comparator.comparingInt(o -> o)));
            String str = next.stream().map(Objects::toString).collect(Collectors.joining("|"));
            if (resultStr.contains(str)) {
                iterator.remove();
            } else {
                resultStr.add(str);
            }
        }
        return result;
    }
    
    public List<List<Integer>> twoSumHashOnce(int[] nums, int target, int excludeIndex) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == excludeIndex) {
                continue;
            }
            int diff = target - nums[i];
            if (set.contains(diff)) {
                List<Integer> list = new ArrayList<>();
                list.add(0 - target);
                list.add(diff);
                list.add(nums[i]);
                result.add(list);
            }
            set.add(nums[i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        SolutionThreeSum solution = new SolutionThreeSum();
        int[] nums = {-1, 0, 1, 1, 2, -1, -1 - 4};
        
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf("%d ", integer);
            }
            
            System.out.println();
        }
    }
}
