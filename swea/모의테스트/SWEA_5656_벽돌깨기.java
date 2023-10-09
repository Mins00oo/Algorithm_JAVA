package swea.모의테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. 먼저 중복순열로 경우의 수를 구해본다.

1
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1

벽돌을 깬 후에 공간을 내려주는 부분만 구현해서 마무리하도록!
 */
public class SWEA_5656_벽돌깨기 {
	static int T, N, W, H, total, des, min = Integer.MAX_VALUE;
	static int[] src, tgt;
	static boolean[] select;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			total = 0; // 답을 구하기 위해 사용할 전체 벽돌 개수, 깬 벽돌을 빼서 답 구하게
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken()); // 열ㅇ
			H = Integer.parseInt(st.nextToken()); // 행
			select = new boolean[W];
			tgt = new int[N];
			src = new int[W];
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for (int i = 0; i < W; i++) {
				src[i] = i;
			}
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						total++;
					}
				}
			}
			
//			perm(0);
			
			destroy(new int[]{2, 2, 6});
			System.out.println(des);
			
			System.out.println(total - des);
			System.out.println(min);
		}
	}
	
//	 중복순열 -> 조합을 찾고 찾은 경우에 대해서 벽돌 깨기를 실시 
	static void perm(int idx) {
		if (idx == N) {
			destroy(tgt);
			min = Math.min(min, total - des);
			return;
		}
		for (int i = 0; i < src.length; i++) {
			tgt[idx] = src[i];
			select[i] = true;
			perm(idx + 1);
			select[i] = false;
		}
	}
	
	static void destroy(int[] tgt) {
		des = 0;
		int[][] copyMap = new int[H][W];
		copyMap = map;
		// 부서야 하는 열의 번호를 가져와서 
		for (int i = 0; i < tgt.length; i++) {
			int col = tgt[i]; // 부서야 하는 열의 번호
			// col에 해당하는 값들 중 맨 위에 벽돌을 부순다.
			int x = 0;
			int y = col;
			for (int j = 0; j < H; j++) {
				if (copyMap[j][col] != 0) {
					x = j;
					break;
				}
			}
			// 부딪히게 될 벽돌의 좌표는 구했으니깐 bfs를 실시
			Queue<int[]> queue = new ArrayDeque<>();
			des++;
			visited[x][y] = true;
			queue.offer(new int[] {x, y});
			
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				int cnt = copyMap[cur[0]][cur[1]]; // 이 cnt만큼 bfs를 넓힐것이기 때문에
//				System.out.println(cur[0] + " " + cur[1] + " " + cnt);
				copyMap[cur[0]][cur[1]] = 0;
				for (int d = 0; d < 4; d++) {
					for (int j = 1; j < cnt; j++) {
						int nx = cur[0] + dx[d] * j;
						int ny = cur[1] + dy[d] * j;
						
						if(nx < 0 || ny < 0 || nx >= W || ny >= H || copyMap[nx][ny] == 0) continue;
						if (!visited[nx][ny]) {
							visited[nx][ny] = true;
							queue.offer(new int[] {nx, ny});
							des++;
						}
						
					}
				}		
			}
			
			for (int j = 0; j < H; j++) {
				for (int j2 = 0; j2 < W; j2++) {
					System.out.print(copyMap[j][j2] + " ");
				}
				System.out.println();
			}
			
			System.out.println("--");
			
			// 벽돌을 bfs로 다 부쉈으면 빈 공간은 내려주고
			for (int c = 0; c < W; c++) {
				
			}
			
		}
	}
	
	static void push() {
		
	}
}














