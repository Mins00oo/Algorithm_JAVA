package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1600_말이되고픈원숭이2 {
	static int K, H, W;
	static int[][] map;
	static boolean[][][] visited; // k가 추가된
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hdx = { -2, -1, -2, -1, 2, 1, 2, 1 };
	static int[] hdy = { -1, -2, 1, 2, -1, -2, 1, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	static class Node {
		int x, y, k, d;

		public Node(int x, int y, int k, int d) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.d = d;
		}
		
		
	}
}
