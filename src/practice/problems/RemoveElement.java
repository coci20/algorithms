/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

/**
 *
 * @author pprasank
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,3,2,3,2,3,2,5,4,3,5,7,6,2,2,3};
        int i = 0, prev = 0;
        int val = 2;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[prev++] = nums[i];                
            } else {
                /* nums[i] == val */
               /* look for continuous values of val */
                while (i < nums.length && nums[i] == val)
                    i++;
                /* nums[j] != val */
                if (i < nums.length) {
                    nums[prev] = nums[i];
                    nums[i] = val;
                    prev++;
                }
            }
            i++;
        }
        for (int p = prev; p < nums.length; p++)
            nums[p] = 0; 
        for (Integer k: nums)
            System.out.print(k + " ");
        System.out.println();
    }
}
