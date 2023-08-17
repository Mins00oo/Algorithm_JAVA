package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 방향을 0, 1, 2, 3순으로 돌려주면서 초기 방향은 1로 설정 dir = 1;
 * 뱀의 움직임을 기록한 후, 3초 뒤에는 방향이 2가 됨 dir 1-> 2
 * D가 나오면 +1을 dir에 더해주고, L이 나오면 +3한 뒤에 나누기 4해서 dir 설정!
 */
public class BOJ_3190_뱀 {
	static int n, k, l; // 보드의 크기 n, 사과의 개수 k개, 방향 전환 횟수 l
	static int[][] apple;
	static List<List<Integer>> turn = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		apple = new int[k][2];
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				System.out.println(st.nextToken());
				System.out.println(st.nextToken());
			}
		}
		
		l = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < l; i++) {
			turn.add(new ArrayList<>());
		}
		
		System.out.println(turn);
		
	}
}
