/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

ACCEPTED!! 
 */
package practice.problems;

/**
 *
 * @author pprasank
 */
public class MinRotatedSorted {
    
    public static void findMinHelper(int[] nums, int low,
            int high, int[] min) {
        if (low > high) return;
        int mid = (low + high)/2;
        if (min[0] > nums[mid]) {
            min[0] = nums[mid];
        }
        if (mid >= low && mid <= high
                && nums[mid] >= nums[low]
                && nums[mid] <= nums[high]) {
            if (min[0] > nums[low]) min[0] = nums[low];
        } else if (mid >= low && nums[mid] > nums[high]){                   
                findMinHelper(nums, mid + 1, high, min);                
        } else if (mid <= high && nums[mid] < nums[low]){
                findMinHelper(nums, low, mid - 1, min);                
        }                
    }
    
    public static int findMin(int[] nums) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        findMinHelper(nums, 0, nums.length - 1, min);
        return min[0];
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,11,12,-13,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }
}
