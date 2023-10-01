package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5 5
D...*
..XXX
.....
.....
.S...

D****
.sXXX
.s...
.s...
.S...
반례) 5
 */
public class BOJ_3055_탈출 {
	static int r, c, min = Integer.MAX_VALUE;
	static int sx, sy, ex, ey; // 출발점, 도착점
	static char[][] map;
	static Queue<int[]> water = new ArrayDeque<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] water_visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		water_visited = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			char[] charArray = br.readLine().toCharArray();
			map[i] = charArray;
			for (int j = 0; j < c; j++) {
				if (charArray[j] == 'S') { // 시작점
					sx = i;
					sy = j;
				}
				if (charArray[j] == 'D') { // 도착점
					ex = i;
					ey = j;
				}
				if (charArray[j] == '*') { // 물이 차있는 지역은 따로 관리
					water_visited[i][j] = true; // 먼저 그냥 방문처리 해주고
					water.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(min);
		}
		
	}
	
	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>(); // 고슴도치 좌표
		boolean[][] visited = new boolean[r][c]; // 고슴도치의 방문을 확인하기 위해
		queue.offer(new int[] {sx, sy, 0}); // x, y 좌표와 이동거리
		visited[sx][sy] = true;
		
		while (!queue.isEmpty()) {
			int wq_size = water.size();
			// 물의 좌표를 가져와서 먼저 전부 확산 시켜주고
			for(int k = 0; k < wq_size; k++) {
				int[] cur_water = water.poll();
				int c_x = cur_water[0];
				int c_y = cur_water[1];
				for (int i = 0; i < 4; i++) {
					int nc_x = c_x + dx[i];
					int nc_y = c_y + dy[i];
					if (nc_x < 0 || nc_x >= r || nc_y < 0 || nc_y >= c) { // 범위를 벗어난다면
						continue;
					}
					if (map[nc_x][nc_y] == 'X' || map[nc_x][nc_y] == 'D' || map[nc_x][nc_y] == 'S') {
						continue;
					}
					if (!water_visited[nc_x][nc_y]) {
						water_visited[nc_x][nc_y] = true;
						map[nc_x][nc_y] = '*';
						water.offer(new int[] {nc_x, nc_y});			
					}
				}
			}
			int q_size = queue.size();
			
			for (int k = 0; k < q_size; k++) {
				int[] cur = queue.poll();
				if (cur[0] == ex && cur[1] == ey) {
					min = Math.min(min, cur[2]);
				}
				// 이제 고슴도치를 이동
				for (int i = 0; i < 4; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c) { // 범위를 벗어난다면
						continue;
					}
					if (map[nx][ny] == 'X' || map[nx][ny] == '*') {
						continue;
					}
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = 'S';
						queue.offer(new int[] {nx, ny, cur[2] + 1});
					}
				}	
			}
		}
	}
}










