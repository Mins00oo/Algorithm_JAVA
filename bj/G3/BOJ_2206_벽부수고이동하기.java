package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][][] visited = new int[N][M][2]; // 부서진 벽인지 아닌지 확인하기 위함

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		queue.add(new int[] { 0, 0, 1, 0 }); // x, y, distance, isBroken
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			System.out.println(Arrays.toString(current));
			int x = current[0];
			int y = current[1];
			int distance = current[2];
			int isBroken = current[3];

			if (x == N - 1 && y == M - 1) {
				System.out.println(distance);
				return;
			}

			for (int[] dir : directions) {
				int nx = dir[0] + x;
				int ny = dir[1] + y;

				// 다음으로 갈 좌표가 범위를 벗어난다면
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				// 방문하지 않은 곳이라면 (벽을 부수고 갈 수도 잇고 아닐 수도 있으니깐 둘 다 확인하기 위해 )
				if (visited[nx][ny][isBroken] == 0) {
					// 벽이 아니라면 그냥 깨지 않고 거리만 늘려서 큐에 추가하고 
					if (map[nx][ny] == 0) {
						queue.offer(new int[] { nx, ny, distance + 1, isBroken });
						visited[nx][ny][isBroken] = 1;
					} else {
						// 벽을 만났기에 부수거나 이미 부순적이 있으면 못 간다
						if (isBroken == 0) {
							queue.offer(new int[] { nx, ny, distance + 1, 1 });
							visited[nx][ny][1] = 1;
						}
					}
				}
			}
		}

		System.out.println(-1);
	}
	
	
}
