package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine()); // 암호문 길이
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int m = Integer.parseInt(br.readLine()); // 명령의 개수
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				if (st.nextToken().equals("I")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					for (int k = 0; k < b; k++) {
						// b만큼의 숫자를 a공간에 넣어야하기 때문에 a를 증가시켜줌
						list.add(a, Integer.parseInt(st.nextToken()));
						a++;
					}
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
