package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "add":
				set.add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				set.remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				if (set.contains(Integer.parseInt(st.nextToken()))) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				int s = Integer.parseInt(st.nextToken());
				if (set.contains(s)) {
					set.remove(s);
				} else {
					set.add(s);
				}
				break;
			case "all":
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		
		System.out.println(sb);
	}
}
