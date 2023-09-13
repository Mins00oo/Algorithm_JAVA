package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20006_랭킹전대기열 {
	static int p, n, l, m; // 플레이어의 수, 닉네임, 레벨, 방의 정원
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken()); // 플레이어 수
		m = Integer.parseInt(st.nextToken()); // 정원 
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
		}
		
	}
	
	static class Node {
		int level;
		String name;
		
		public Node(int level, String name) {
			super();
			this.level = level;
			this.name = name;
		}
		
		
	}
}
