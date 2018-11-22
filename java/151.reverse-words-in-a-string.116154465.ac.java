/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.73%)
 * Total Accepted:    235.7K
 * Total Submissions: 1.5M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * Example:  
 * 
 * 
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * 
 */
public class Solution {
    public String reverseWords(String s) {
        String[]  sa = s.split(" ");
        String res = "";
        for (String ss : sa) {
            String sb = ss.replaceAll(" ","");
            if (sb.compareTo("") != 0) {
                sb = new StringBuilder(sb).reverse().toString();
                res = res + sb + " ";
            }
        }
        res = new StringBuilder(res.trim()).reverse().toString();
        return res;
    }
}
