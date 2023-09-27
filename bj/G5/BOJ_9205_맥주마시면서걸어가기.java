package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	static int T, c_num;
	static int start_x, start_y;
	static int arrive_x, arrive_y;
	static List<Node> store;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			store = new ArrayList<>();
			c_num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < c_num; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store.add(new Node(x, y));
			}
			
			st = new StringTokenizer(br.readLine());
			arrive_x = Integer.parseInt(st.nextToken());
			arrive_y = Integer.parseInt(st.nextToken());
			
			if (bfs()) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}
		}
		
		System.out.println(sb);
	
	}
	
	static boolean bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[c_num]; // 편의점 개수만큼 만들어서 방문했는지 확인
		queue.offer(new Node(start_x, start_y)); // 시작점을 담아서 시작
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			// 현재 점으로부터 도착점까지 걍 갈 수 있으면 바로 끝
			if (Math.abs(arrive_x - cur.x) + Math.abs(arrive_y - cur.y) <= 1000) {
				return true;
			}
			
			for (int i = 0; i < c_num; i++) {
				if (!visited[i]) { // 방문하지 않은 편의점이라면
					if (Math.abs(store.get(i).x - cur.x) + Math.abs(store.get(i).y - cur.y) <= 1000) {
						visited[i] = true;
						queue.offer(new Node(store.get(i).x, store.get(i).y));
					}
				}
			}
		}
		return false;
		
	}
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
}










