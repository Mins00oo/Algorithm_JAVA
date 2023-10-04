package bj.G1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 가로 방향인 다리는 가로 방향으로 인접 -> 좌우로만 인접해야함 , 세로 방향 다리는 세로 방향으로만 -> 상하로만 인접해야함
 * 0은 바다, 1은 땅 / 세로 크기 n , 가로 크기 m 
 */
public class BOJ_17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<List<int[]>> isLand = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i <= 6; i++) {
			isLand.add(new ArrayList<>());
		}
		
		System.out.println(isLand);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					if (!visited[i][j]) {
						bfs(i, j, index++);
					}
				}
			}
		}
		
		for (List<int[]> is : isLand) {
			for (int[] s : is) {
				System.out.print(Arrays.toString(s) + " ");
			}
			System.out.println();
		}
		
		
	}
	
	static void bfs(int x, int y, int idx) {
		visited[x][y] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (!visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					isLand.get(idx).add(new int[] {nx, ny});
				}
			}
		}
	}
}










