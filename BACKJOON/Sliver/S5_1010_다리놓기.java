package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 서쪽게이트에서 첫번째 인덱스부터 시작해서 놓아줘야 하는 tgt에 놓아주는데 배정받을때마다 그냥 +1씩 해주고
 * 시간초과 발생 -> 어떻게 해결할 ㅅ ㅜ있을까 ..
 */
public class S5_1010_다리놓기 {
	static int T, n, m; // 테스트 케이스 개수, 서쪽 사이트 개수, 동쪽 사이트 개수
	static StringTokenizer st;
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			fun(0, 0);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void fun(int stIdx, int connect) {
		
		if (connect == n) {
			cnt++;
			return;
		}
//		for (int i = stIdx; i < m; i++) {
//			fun(i + 1, connect + 1);
//		}
		if (stIdx == m) {
			return;
		}
		fun(stIdx + 1, connect + 1);
		fun(stIdx + 1, connect);
	}

}
