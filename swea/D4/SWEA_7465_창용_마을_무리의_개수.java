package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
1
6 5
1 2
2 5
5 1
3 4
4 6

# 1 2
 */
public class SWEA_7465_창용_마을_무리의_개수 {
	static int T, N, M, ans;
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			visited = new boolean[N + 1];
			ans = 0;
			
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					bfs(i);
					ans++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int s) {
		visited[s] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(s);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int li : list.get(cur)) {
				if (!visited[li]) {
					queue.offer(li);
					visited[li] = true;
				}
			}
		}
	}
}











