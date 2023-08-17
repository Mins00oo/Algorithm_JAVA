package bj.G2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 방문처리를 어떻게 할 건지? -> 따로 자료구조를 사용할 것인가 
 * 핵심은 이 문제에서 visited원복 처리를 해줄 필요가 없음 ! 
 * dfs void로 리턴타입을 설정하면 안됨!! -> for문에서 특정 방향으로 파이프를 연결했다면 다른 루트를 보면 안되는데
 * 재귀 밖으로 나와서 for문에서도 다음 값으로 또 들어가기 때문에 제출하면 실패로 나옴!
 */
public class BOJ_3109_빵집 {
	static int R, C, ans;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				ans++;
			}
		}
		System.out.println(ans);

	}

	static boolean dfs(int x, int y) {
		int ny = y + 1;
		if (ny == C - 1) {
			return true;
		}
		for (int d : new int[] { -1, 0, 1 }) {
			int nx = x + d;
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'x') {
				continue;
			}
			map[nx][ny] = 'x';
			if (dfs(nx, ny)) {
				return true;
			}
		}
		return false;
	}
}
