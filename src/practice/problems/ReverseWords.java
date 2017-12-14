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
public class ReverseWords {
    public static void main(String args[]){
       String s = "Let's take LeetCode contest";
       String[] strs = s.split(" ");
       String res="";
       for (int i = 0; i < strs.length; i++)
           strs[i] = new StringBuilder(strs[i]).reverse().toString();
       for (String ss: strs) {
           res+=ss;
           res+=" ";
       }
       System.out.println(res.trim());
    }
}
