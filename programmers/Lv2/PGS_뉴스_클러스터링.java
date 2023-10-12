package programmers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class PGS_뉴스_클러스터링 {
	static HashMap<String, Integer> set1 = new HashMap<>(); // str1 문자열에 대한 리스트
	static HashMap<String, Integer> set2 = new HashMap<>(); // str2 문자열에 대한 리스트
	static HashMap<String, Integer> union = new HashMap<>();
	static HashMap<String, Integer> intersection = new HashMap<>();
	static int inter_size;
	static int union_size;

	public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		// str1 문자열에 대해서
		for (int i = 0; i < str1.length() - 1; i++) {
			char s1 = str1.charAt(i);
			char s2 = str1.charAt(i + 1);
			if ('a' <= s1 &&  s1 <= 'z' && 'a' <= s2 && s2 <= 'z') {
				if (set1.containsKey(str1.substring(i, i + 2))) { // 이미 존재하는 문자열이라면 value + 1
					set1.put(str1.substring(i, i + 2), set1.get(str1.substring(i, i + 2)) + 1);
				} else {
					set1.put(str1.substring(i, i + 2), 1);	
				}
			}
		}
		
		for (int i = 0; i < str2.length() - 1; i++) {
			char s1 = str2.charAt(i);
			char s2 = str2.charAt(i + 1);
			if ('a' <= s1 &&  s1 <= 'z' && 'a' <= s2 && s2 <= 'z') {
				if (set2.containsKey(str2.substring(i, i + 2))) { // 이미 존재하는 문자열이라면 value + 1
					set2.put(str2.substring(i, i + 2), set2.get(str2.substring(i, i + 2)) + 1);
				} else {
					set2.put(str2.substring(i, i + 2), 1);	
				}
			}
		}
		
		if (set1.size() == 0 && set2.size() == 0) {
			return 65536;
		}
		
		// set1을 돌면서 set2에 해당 키가 있다면 value를 비교해서 작은 값을 교집합에 넣어준다. 해당 키가 없다면 그냥 cotinue
		for (Map.Entry<String, Integer> entry : set1.entrySet()) {
			if (set2.containsKey(entry.getKey())) {
				intersection.put(entry.getKey(), Math.min(entry.getValue(), set2.get(entry.getKey())));
			}
		}
		
		// 합집합 구해주기 -> set1의 키가 set2에 있다면 최댓값으로 넣어주고 없다면 그냥 그대로 put
		// 이때 아직 set2에 못 넣은 값이 있을 수 있기 때문에 set2를 다시 for문으로 돌면서 이미 key값이 있는 애들은 건너뛰고 나머지는 put
		// 1:2 , 2:2 3:1   / 1:1 , 2:2, 4:1, 5:1
		for (Map.Entry<String, Integer> entry1 : set1.entrySet()) {
			if (set2.containsKey(entry1.getKey())) {
				union.put(entry1.getKey(), Math.max(entry1.getValue(), set2.get(entry1.getKey())));
			} else {
				union.put(entry1.getKey(), entry1.getValue());
			}
		}
		
		for (Map.Entry<String, Integer> entry2 : set2.entrySet()) {
			if (union.containsKey(entry2.getKey())) {
				continue;
			}
			union.put(entry2.getKey(), entry2.getValue());
		}
		
		for (Map.Entry<String, Integer> intersect : intersection.entrySet()) {
			inter_size += intersect.getValue();
		}
		
		for (Map.Entry<String, Integer> unions : union.entrySet()) {
			union_size += unions.getValue();
		}
		
		
		double jakart = (double) inter_size / (double) union_size;
		return (int) (jakart * 65536) ;
	}

	public static void main(String[] args) {
		System.out.println(new PGS_뉴스_클러스터링().solution("aa1+aa2", "AAAA12"));
	}
}








