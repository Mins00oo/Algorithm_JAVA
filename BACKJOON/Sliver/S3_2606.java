package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2606 {
	static int[][] computer; // 컴퓨터가 서로 연결된 정보
	static int n; // 컴퓨터 개수
	static int line; // 쌍의 개수
	static StringTokenizer st;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		computer = new int[n + 1][n + 1];
		for (int i = 1; i <= line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computer[a][b] = 1; // 서로 연결되어있는지 여부
			computer[b][a] = 1;
		}
		visited = new boolean[n + 1];
		sol(1);
		System.out.println(count);
	}

	public static void sol(int start) {
		visited[start] = true;
		for (int i = 1; i <= n; i++) {
			if (computer[start][i] == 1 && !visited[i]) {
				count++;
				sol(i);
			}
		}
	}
}
