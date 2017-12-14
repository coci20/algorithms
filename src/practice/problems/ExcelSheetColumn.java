package practice.problems;

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */


import java.util.HashMap;

/**
 *
 * @author pprasank
 */
public class ExcelSheetColumn {
    
    public static String convertToTitle(int n) {
        String str = "";
        HashMap<Integer, Character> map =
                new HashMap<>();
        
        map.put(0, 'Z');
        char c = 'A';
        int i = 1;
        for (; c < 'Z' && i < 26; c++, i++) {
            map.put(i, c);
        }
        
        while (n > 0) {
            int p = n % 26;
            str += map.get(p);
            System.out.println(p);
            if (p >=1 && p <=25)
                n = (n-p)/26;
            else if (p == 0){
                if (n == 1) break;
                n = (n - 26)/26;
            }
        }
        return new StringBuilder(str).reverse().toString();
    }
    public static void main(String[] args) {
        int n = 16900;
        System.out.println(convertToTitle(n));
    }
}
