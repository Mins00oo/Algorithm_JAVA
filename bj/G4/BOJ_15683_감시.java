package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	static int N, M;
	static int[][] map; // 원본 저장

	static ArrayList<Node> cctv = new ArrayList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0 || map[i][j] == 6)
					continue;
				cctv.add(new Node(i, j, map[i][j]));
			}
		}

		comb(0);
		System.out.println(result);
	}

	static int[][] return_dir(int num) {
		if (num == 1) {
			return new int[][] { { 0 }, { 1 }, { 2 }, { 3 } };
		} else if (num == 2) {
			return new int[][] { { 0, 1 }, { 2, 3 } };
		} else if (num == 3) {
			return new int[][] { { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };
		} else if (num == 4) {
			return new int[][] { { 2, 0, 3 }, { 0, 3, 1 }, { 1, 2, 3 }, { 0, 1, 2 } };
		} else {
			return new int[][] { { 0, 1, 2, 3 } };
		}
	}

	static void start_cctv(int x, int y, int dir) {
		while (true) {
			x += dx[dir];
			y += dy[dir];
			if (!isCango(x, y))
				break;
			if (map[x][y] == 6)
				break;
			if (map[x][y] != 0)
				continue;
			map[x][y] = -1;
		}
	}

	static void get_region() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					sum++;
			}
		}

		result = Math.min(result, sum);
	}

	static void comb(int cnt) {
		if (cnt == cctv.size()) {
			// 사각지대 구하기
			get_region();
			return;
		}
		// temp 복사
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++)
			temp[i] = map[i].clone();

		Node cur = cctv.get(cnt); // 현재 CCTV
		// 현재 cctv가 회전할 수 있는 방향을 받아와서
		int[][] direction = return_dir(cur.num);

		// 그 방향 따라서 cctv 탐색
		for (int i = 0; i < direction.length; i++) {
			for (int d : direction[i]) {
				start_cctv(cur.x, cur.y, d);
			}

			comb(cnt + 1);
			// map 원복
			for (int j = 0; j < N; j++)
				map[j] = temp[j].clone();
		}
	}

	static boolean isCango(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		return true;
	}

	static class Node {
		int x, y;
		int num;

		Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
