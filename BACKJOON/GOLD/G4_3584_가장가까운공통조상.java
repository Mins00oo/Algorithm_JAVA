package BACKJOON.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_3584_가장가까운공통조상 {
	static int T, n;
	static List<List<Integer>> list;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list.get(to).add(from);
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			System.out.println(list);
			sol(c1, c2);
		}
		System.out.println(sb);
	}

	static void sol(int n1, int n2) {
		// 부모를 찾아갔더니 바로 같은 부모라면 그대로 출력
		if (list.get(n1).get(0) == list.get(n2).get(0)) {
			sb.append(list.get(n1).get(0)).append("\n");
			return;
		}
		// 다른 부모일 경우 각자 부모를 계속 찾아가면서 비교
		while (true) {
			
		}

	}
}
