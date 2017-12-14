package practice.problems;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prasannjitk
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,4,3,5,5,3,1};
        int sum = 0;
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            total += k;
            if (!list.contains(k))
                list.add(k);
            else
                sum += k;
        }
        System.out.println(total - (2 * sum));
    }
}
