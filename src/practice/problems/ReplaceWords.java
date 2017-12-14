/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prasannjitk
 */
public class ReplaceWords {
    
    public static String replaceWords(List<String> dict, String sentence) {
        Map<String, String> map = new HashMap<>();
        String[] strings = sentence.split(" ");
        for(String w : dict) {
            for(String token: strings) {
                if(token.startsWith(w)) {
                    if(!map.containsKey(token)){
                        map.put(token, w);
                    } else {
                        if(map.get(token).length() > w.length()){
                            map.put(token, w);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strings) {
            if(map.containsKey(s)){
                sb.append(map.get(s));
            } else
                sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
    }
}
