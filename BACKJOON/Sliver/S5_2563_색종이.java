package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 좌표값들을 입력받은 후 , 가로 혹은 세로가 겹치는지 확인해줘야함
 * 그러기 위해서 좌표값 x,y에 10을 더해서 확인해야하나 했지만 그렇겧면 다른 색종이가 또 붙으면 넘 골치아픔
 * 그렇기 때문에 그냥 값을 받아줄때 체크여부를 통해 true로 바꿔주면서 횟수 +1을 해주면 됨
 * 풀이 아이디어는 체크여부라는걸 만들어주면서 칸 하나하나씩 +1을 해준다는 생각으로!
 */
public class S5_2563_색종이 {
	static int n; // 색종이의 수
	static StringTokenizer st;
	static int cnt;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		checked = new boolean[101][101];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (!checked[j][k]) {
						cnt++;
						checked[j][k] = true;

					}
				}
			}
		}
		System.out.println(cnt);

	}
}
