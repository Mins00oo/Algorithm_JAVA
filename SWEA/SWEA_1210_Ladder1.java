package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 2차원배열을 행 기준으로 탐색하면서 좌표값이 1인 좌표부터 탐색을 시작한다.
 * 2. 위로는 이동할 수 없고 아래로 이동하는데 방향전환은 좌우로 가능!! 근데 전환했으면 무조건 다음은 아래임!
 * 2.1 그럼 이전에 갔던 걸 확인하고 좌우로 간거면 아래로만 갈 수 있도록 다음 방향을 잡아줘야 할듯
 * 3. 다음 방향 잡았으면 범위 안에 속하는지 확인하고 그 값이 1이면 이동하고 아니면 돌아온다.
 * 3.1 여기서 만약에 다음 방향이 맨 마지막 즉 100번째라면 그 도달했다는 의미이기에 시작점을 출력하면 될듯
 * 
 * ----- 다시 수정 -----
 * 1. 도착점이 2라고 표시되어있는거를 못 보고 품.. 도착 지점을 먼저 찾아낼 수 있기 때문에 x, y좌표를 찾아낸다.
 * 2. 거꾸로 올라간다는 생각으로 방향을 잡기에 원래는 '하, 좌, 우'만 가능한데 '상, 좌, 우' 로 움직인다.
 * 3. 이때, 움직일 수 있는 곳은 범위 내에 있으면서 아직 가지 않은 곳이다. -> 이때 아직 가지 않은 곳을 따로 만들어도 되긴 할건데 어차피 정해진 값이 0,1,2 밖에 없으니깐 걍 3이나 그 외에 값으로 아무거나 해도 됨
 * 4. 이렇게 움직이면서 x, y 좌표를 바꿔주고 만약에 x값이 0으로 맨 위에 도착했다면 찾고자 하는 y값을 출력하면 된다.
 * 5. 그리고 생각해보니 사다리로만 움직일 수 있으니깐 움직이는 조건에 좌표값이 1인지를 확인해줘야 함
 */
public class SWEA_1210_Ladder1 {
	static int t_num; // 테케 번호
	static int[][] ladder;
	static StringTokenizer st;
	static int[] dx = { -1, 0, 0 };
	static int[] dy = { 0, -1, 1 };
	static int arrive_x = 99;
	static int arrive_y;
	static int answer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			t_num = Integer.parseInt(br.readLine());
			ladder = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						arrive_y = j;
					}
				}
			}
//			// 시작좌표는 별도의 for문 이용처리
//			arrive_x = 99;
//			for (int i = 0; i < 100; i++) {
//				if (ladder[99][i] == 2) {
//					arrive_y = i;
//					break;
//				}
//			}
			sol(arrive_x, arrive_y);
			System.out.println("#" + t_num + " " + answer);
		}

	}

	static void sol(int x, int y) {
		while (true) {
			if (x == 0) { // 출발점에 도달했다면
				answer = y;
				sb.append("#").append(1).append(" ").append(answer).append("\n");
				break;
			}
			for (int i = 0; i < 3; i++) { // 방향을 도착점부터 시작점 찾는거처럼
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if ((nx >= 0 && nx < 100) && (ny >= 0 && ny < 100) && ladder[nx][ny] == 1) {
					ladder[nx][ny] = 3;
					x = nx;
					y = ny;
				}
			}
		}
	}
}
