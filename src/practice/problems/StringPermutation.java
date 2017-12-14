/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author prasannjitk
 */
public class StringPermutation {
    public static void getPermutation(String input, 
            String rem, List<String> list) {
        if(input.length() == 0)
            list.add(rem);
        else {
            for(int i = 0; i < input.length(); i++) {
                String left = input.substring(0,i) + 
                        input.substring(i+1);
                String next = rem + input.charAt(i);
                getPermutation(left, next, list);
            }
        }
    }
    public static void main(String[] args) {
        String input = "ACBEC";
        List<String> list = new ArrayList<>();
        getPermutation(input, "", list);
        System.out.println(Arrays.asList(list));
    }
}
