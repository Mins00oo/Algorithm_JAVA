package bj.B1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1157_단어공부 {
	static HashMap<Character, Integer> hashMap = new HashMap<>();
	static Character ans;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String lowerCase = s.toLowerCase();
		
		for (int i = 0; i < lowerCase.length(); i++) {
			if (hashMap.containsKey(lowerCase.charAt(i))) {
				hashMap.put(lowerCase.charAt(i), hashMap.get(lowerCase.charAt(i)) + 1);
			} else {
				hashMap.put(lowerCase.charAt(i), 1);	
			}
		}
		
		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			if (min < entry.getValue()) {
				min = entry.getValue();
				ans = entry.getKey();
			} else if (min == entry.getValue()) {
				ans = '?';
			}
		}
		
		System.out.println(Character.toUpperCase(ans));
	}
}
