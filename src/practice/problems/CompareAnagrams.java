package practice.problems;


import java.util.Arrays;
import java.util.Comparator;

public class CompareAnagrams implements Comparator<String> {
	public String compareChars(String s) {
		char[] myArr = s.toCharArray();
		Arrays.sort(myArr);
		return new String(myArr);
	}

	@Override
	public int compare(String s1, String s2) {
		return compareChars(s1).compareTo(compareChars(s2));
	}

	public void Solution(String[] arr) {
		Arrays.sort(arr, new CompareAnagrams());
	}
}

