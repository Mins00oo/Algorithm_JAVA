package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2468 {
	static int n; // 2차원 배열의 가로 세로 길이
	static int[][] region;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static StringTokenizer st;
	static int max;
	static boolean[][] visited;
	static int count;
	static int answer = 1; // 아무 지역도 물에 안잠기면 전체 뭉덩이가 1개이기에 최소 1개는 무조건 나옴

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		region = new int[n][n];

		// 영역별 높이 넣어주고 최댓값 설정
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				region[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(region[i][j], max);
//                System.out.print(region[i][j]);
			}
//            System.out.println();
		}

		// 높이의 최댓값만큼 반복하면서 높이보다 큰 영역이고 방문 안한곳이면 dfs로 깊게 계속 연결되는 곳까지 방문체크
		for (int h = 1; h <= max; h++) {
			visited = new boolean[n][n];
			count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (region[i][j] > h && !visited[i][j]) {
						count++;
						dfs(i, j, h);
					}
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}

	static void dfs(int x, int y, int h) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && !visited[nx][ny] && region[nx][ny] > h) {
				dfs(nx, ny, h);
			}
		}
	}
}
