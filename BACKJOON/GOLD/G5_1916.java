package BACKJOON.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 버스 정보를 갖고 있을 2차원 배열을 생성해서 담아준다. 행 길이는 버스 개수만큼 생성하고 열의 길이는 3
 * 2. 이제 주어진 출발 도시부터 시작해서 도착점까지 처음에 걸리는 비용을 min 최소로 잡는다
 * 3. 다음 탐색을 돌 때 전부 다 돌기보다는 이 최솟값보다 재귀하는 과정에서 더 비용이 커지면 그냥 리턴시킨다 -> 어차피 볼 필요가 없음
 */
public class G5_1916 {
	static int n; // 도시의 개수
	static int m; // 버스의 개수
	static int[][] busInfo; // 버스의 연결정보
	static StringTokenizer st;
	static int start;
	static int end;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		busInfo = new int[m][3];

		for (int i = 0; i < m; i++) { // 버스 연결 정보를 생성해서 넣어줌
			st = new StringTokenizer(br.readLine(), " ");
			busInfo[i][0] = Integer.parseInt(st.nextToken());
			busInfo[i][1] = Integer.parseInt(st.nextToken());
			busInfo[i][2] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()); // 시작점
		end = Integer.parseInt(st.nextToken()); // 도착점

		dfs(start, end, 0);
	}

	static void dfs(int s, int e, int c) {
	}

}
