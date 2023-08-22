package swea.D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	static int T, N, min;
	static int[][] list;
	static int[] start;
	static int[] end;
	static int[] tgt;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			min = Integer.MAX_VALUE;
			start = new int[2];
			end = new int[2];
			N = Integer.parseInt(br.readLine());
			tgt = new int[N];
			selected = new boolean[N + 1];
			list = new int[N + 1][2];
			st = new StringTokenizer(br.readLine());

			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) {
				list[i][0] = Integer.parseInt(st.nextToken());
				list[i][1] = Integer.parseInt(st.nextToken());
			}

			perm(0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);

	}

	static void perm(int idx) {
		if (idx == N) {
			int cal = cal(tgt);
			min = Math.min(min, cal);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				continue;
			}
			tgt[idx] = i;
			selected[i] = true;
			perm(idx + 1);
			selected[i] = false;
		}
	}

	static int cal(int[] tgt) {
		// 시작점과 맨 앞에 점과의 거리 + 도착점과 맨 뒷점의 거리
		int[] front = list[tgt[0]]; // 출발 지점
		int[] back = list[tgt[N - 1]]; // 도착 지점
		int sum = 0;
		int s_dis = Math.abs(front[0] - start[0]) + Math.abs(front[1] - start[1]); // 출발 지점과 맨 앞의 지점과의 거리
		int e_dis = Math.abs(back[0] - end[0]) + Math.abs(back[1] - end[1]); // 도착 지점과 맨 뒤의 점과의 거리

		// 순열을 통해 구한 점 들 끼리의 사이 간격을 더해주고
		for (int i = 0; i < N - 1; i++) {
			int[] a = list[tgt[i]];
			int[] b = list[tgt[i + 1]];
			sum += (Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]));

		}
		// 처음 구해놓은 시작점과 끝점까지의 거리 더해주고
		sum += s_dis + e_dis;

		return sum;
	}

}
