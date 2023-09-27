package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4659_비밀번호발음하기 {
	static String[]	checkList = {"a", "i", "o", "u", "e"};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String password = br.readLine();
			
		}
		
		System.out.println(sb);
	}
}
