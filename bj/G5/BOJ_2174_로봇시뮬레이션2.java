package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2174_로봇시뮬레이션2 {
	static int A, B, N, M;
	static HashMap<Integer, int[]> robots = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken()); // 가로
		B = Integer.parseInt(st.nextToken()); // 세로

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 로봇 수
		M = Integer.parseInt(st.nextToken()); // 명령 수

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int d = "NESW".indexOf(dir);
			robots.put(i, new int[] { x, y, d });
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int robot = Integer.parseInt(st.nextToken());
			String cmd = st.nextToken();
			int iter = Integer.parseInt(st.nextToken());

			for (int j = 0; j < iter; j++) {
				if (!executeCmd(robot, cmd)) {
					System.out.println(sb.toString());
					return;
				}
			}
		}
		sb = new StringBuilder();
		sb.append("OK");
		System.out.println(sb);
	}

	public static boolean executeCmd(int robot, String cmd) {
		int[] pos = robots.get(robot);
		int x = pos[0], y = pos[1], dir = pos[2];

		if (cmd.equals("L")) {
			dir = (dir + 3) % 4;
		} else if (cmd.equals("R")) {
			dir = (dir + 1) % 4;
		} else {
			int dx = 0, dy = 0;
			if (dir == 0)
				dy = 1;
			else if (dir == 1)
				dx = 1;
			else if (dir == 2)
				dy = -1;
			else if (dir == 3)
				dx = -1;

			x += dx;
			y += dy;

			if (x < 1 || x > A || y < 1 || y > B) {
				sb.append("Robot ").append(robot).append(" crashes into the wall");
				return false;
			}

			for (int other : robots.keySet()) {
				if (other == robot)
					continue;
				int[] otherPos = robots.get(other);
				if (otherPos[0] == x && otherPos[1] == y) {
					sb.append("Robot ").append(robot).append(" crashes into robot ").append(other);
					return false;
				}
			}
		}
		robots.put(robot, new int[] { x, y, dir });
		return true;
	}
}
