/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 *
 * https://leetcode.com/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (30.18%)
 * Total Accepted:    45.9K
 * Total Submissions: 151.9K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * 
 * Example 1:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 * 
 * 
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 0)
                return true;
            else
                return (n == 0);
        }        
        
        int count = 0;
        int[] pos = new int[2];
        if(flowerbed[0] == 0) {
            pos[1] = 0;
            count++;
        }        
        int i = 1;
        
        while(i < flowerbed.length) {
            if(flowerbed[i] == 0)
                pos[0] = i;
            else if(pos[0] == pos[1]) {
                count--;
                pos[1] = i;
            } else{
                pos[1] = i;
            }
            if(Math.abs(pos[0] - pos[1]) > 1) {
                pos[1] = pos[0];
                count++;
            }
            i++;
        }
        return count >= n ;
    }
}
