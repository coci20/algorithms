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
public class MinSumPartition {
    public static void minSumPart(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for(int i = 0; i <= n; i++)
            dp[i][0] = true;
        for(int i = 1; i < dp[0].length; i++)
            dp[0][i] = false;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        int max = Integer.MAX_VALUE;
        for(int i = sum/2; i >= 0; i--) {
            if(dp[n][i]) {
                max = sum - 2 * i;
                break;
            }
        }
        System.out.println("subset sum minimum is " + max);
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2, 5, 8,3};
        minSumPart(nums);
    }
}
