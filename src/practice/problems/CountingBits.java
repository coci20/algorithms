package practice.problems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pprasank
 */
public class CountingBits {
    
    public static int count_bits(int num) {
        int count = 0;
        System.out.print("for " + num + " binary rep: ");
        for (int i = 1<<30; i > 0; i=i/2) {
            if((num & i) > 0) {
                count++;
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
        return count;
    }
    public static void main(String[] args) {
        int num = 5;
        int[] nums = new int[num+1];
        for (int i = 0; i <= num; i++)
            nums[i] = count_bits(i);
        for(Integer k : nums)
            System.out.println(k);
    }
}
