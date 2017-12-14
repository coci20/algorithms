/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.dynamic;

/**
 *
 * @author prasannjitk
 */
public class LIS {
    public static void lis(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        for(int i = 0; i < n; i++) {
            LIS[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }
        int max = LIS[0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, LIS[i]);
        }
        System.out.println("LIS(nums) = " + max);
    }
    public static void main(String[] args) {
        int[] nums = {10, 20, 9, 33, 21, 50, 41, 60};
        lis(nums);
    }
}
