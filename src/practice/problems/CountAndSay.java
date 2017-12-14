package practice.problems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author pprasank
 */
public class CountAndSay {
    
    public static void countAndSayHelper(ArrayList<String> list, int k) {
        String str = list.get(k);
        char[] ca = str.toCharArray();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < ca.length; i++)
            st.push(ca[ca.length - i -1]);
        
        String res="";
        int count;
        while (!st.isEmpty()) {
            count = 1;
            char c = st.pop();
            while (!st.isEmpty() && c == st.peek()) {
                st.pop();
                count++;
            }            
            res = res + String.valueOf(count) + String.valueOf(c);            
        }
        list.add(res);
    }
    
    public static String countAndSay(int n) {
        String str = "1";
        ArrayList<String> list = new ArrayList<>();
        list.add(str);
        for (int i = 1; i < n; i++) {
            countAndSayHelper(list, i-1);            
        }
        return list.get(n-1);
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("ans is " + countAndSay(n));
    }
}
