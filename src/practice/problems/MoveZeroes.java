/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

/**
 *
 * @author prasannjitk
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == 0) continue;
            int j = i - 1;
            while (j >= 0 && nums[j] == 0) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                j--;
            }
        }
        for (Integer i: nums)
            System.out.print(i + " ");
        System.out.println();
        
       
    }
    
    
}
