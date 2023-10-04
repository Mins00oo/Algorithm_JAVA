package bj.P4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// a	b	a	c	a	a	b	a

public class BOJ_1786_찾기 {
	static int[] pi;
	static int cnt;
	static String T, P;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		
		kmp(T, P);
		System.out.println(cnt);
		System.out.println(sb);
		System.out.println(Arrays.toString(pi));
	}
	
	static void kmp(String text, String pattern) {
		makePi(pattern);
		// 패턴 매칭
		int tLen = text.length();
		int pLen = pattern.length();
		char[] tArray = text.toCharArray();
		char[] pArray = pattern.toCharArray();
		
		int j = 0;
		for (int i = 0; i < tLen; i++) {
			while (j > 0 && tArray[i] != pArray[j]) j = pi[j - 1];
			// 현재 text의 i번째 글자와 pattern j번째 글자가 일치한 상황
			if (tArray[i] == pArray[j]) {
				if (j == pLen - 1) { // 모두 일치 
					cnt++;
					sb.append(i - j  + 1).append(" ");
					j = pi[j];
				} else { // 일부 일치
					j++; // 나머지 일치를 확인하기 위해서 index 하나 증가
				}
			}
		}
	}
	
	static void makePi(String p) {
		pi = new int[p.length()];
		char[] pArray = p.toCharArray();
		// j는 접두사 인덱스
		int j = 0;
		// i는 접미사 인덱스로 간주
		for (int i = 1; i < pArray.length; i++) {
			// i번째 값 j번째 값이 일차하거나 j == 0이면 while문 벗어남
			while (j > 0 && pArray[i] != pArray[j]) {
				j = pi[j - 1];
			}
			// 현재 시점은 j == 0이거나 i번째 값하고 j번째 값이 일치
			if (pArray[i] == pArray[j]) {
				pi[i] += ++j;
			}
		}
	}
}
