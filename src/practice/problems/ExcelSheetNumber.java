package practice.problems;

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
ACCEPTED!!
 */


import java.util.HashMap;

/**
 *
 * @author pprasank
 */
public class ExcelSheetNumber {
    public static int titleToNumber(String s) {
        int base = 26;
        int key = 0;
        HashMap<Character, Integer> map =
                new HashMap<>();
        
        char c = 'A';
        int i = 1;
        for (; c <= 'Z' && i <= 26; c++, i++) {
            map.put(c, i);
        }
        for (i = 0; i < s.length(); i++) {
            key = key*base + map.get(s.charAt(i));
        }
        return key;
    }
    public static void main(String[] args) {
        String s = "Z";
        System.out.println(titleToNumber(s));
    }
}
