package club.movon.leetcode.solutions;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author zhangzhipeng
 * @date 2019-01-31
 */
public class SolutionSearchInRotatedSortedArray {
    
    public int search(int[] nums, int target) {
        
        int spinIndex = findSpinIndex(0, nums.length - 1, nums);
        if (spinIndex != -1) {
            if (nums[0] <= target) {
                return search(target, 0, spinIndex, nums);
            } else {
                return search(target, spinIndex + 1, nums.length - 1, nums);
            }
        }
        return search(target, 0, nums.length - 1, nums);
    }
    
    /**
     * 查找旋转点
     *
     * @param left
     * @param right
     * @param nums
     * @return
     */
    private int findSpinIndex(int left, int right, int[] nums) {
        if (left >= right) {
            return -1;
        }
        
        int mid = (right + left) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return mid;
        }
        
        int spinIndexL = findSpinIndex(mid + 1, right, nums);
        if (spinIndexL != -1) {
            return spinIndexL;
        }
        int spinIndexR = findSpinIndex(left, mid, nums);
        if (spinIndexR != -1) {
            return spinIndexR;
        }
        return -1;
    }
    
    /**
     * 二分查找
     *
     * @param target
     * @param left
     * @param right
     * @param nums
     * @return
     */
    private int search(int target, int left, int right, int[] nums) {
        if (left > right) {
            return -1;
        }
        
        int mid = (right + left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return search(target, mid + 1, right, nums);
        } else {
            return search(target, left, mid - 1, nums);
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        
        SolutionSearchInRotatedSortedArray solution = new SolutionSearchInRotatedSortedArray();
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));
        System.out.println(solution.search(nums, 5));
        
    }
}
