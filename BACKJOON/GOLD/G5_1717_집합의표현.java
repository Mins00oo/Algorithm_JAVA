package BACKJOON.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 같은 집합에 있는지 여부 판별을 어떻게 할지 ? -> 예를 들어 [1, 2, 1, 2, 5, 6, 1] 있을때 6 7은 서로 연결되어 있지만
 * find로 parent만 찾을때는 연결 x로 나옴
 * -> 알고보니 그냥 union해주는 과정에서 값을 잘못 넣어줘서 그런듯 ..
 */
public class G5_1717_집합의표현 {
	static int n, m; // n은 숫자, m은 연산의 개수
	static int[] parent;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		// parent 배열 초기 설정
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		// 입력값에 따라 연산 수행
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int operator = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (operator == 0) {
				// 합집합 연산을 수행
				union(from, to);
			} else if (operator == 1) {
				int find_p = find(from); // 6
				int to_p = find(to); // 1
				if (find_p == to_p) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
//		System.out.println(Arrays.toString(parent));
		System.out.println(sb);
	}

	static void union(int a, int b) {
		int a_parent = find(a);
		int b_parent = find(b);
		// 서로 부모가 다를때 union 가능! 사이클이 안생기기 위해
		if (a_parent != b_parent) {
			if (a_parent < b_parent) {
				parent[b_parent] = a_parent;
			} else {
				parent[a_parent] = b_parent;
			}
		}
	}

	static int find(int x) {
		// 전달받은 x의 부모를 찾기
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
