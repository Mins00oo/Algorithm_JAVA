package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * + + - * % , 1 2 3 4 5 6이 있으면 
 * 연산자를 우선 주어진 입력값으로 받아주고 입력값을 반복하면서 재귀를 통해 연산을 계속 수행해나간다
 * 앞에서부터 연산 순서는 정해져있으니깐 switch문을 통해 각 case에 따라 연산 결과를 수행하고 누적해나가는데
 * 해당 인덱스의 값을 -1씩ㄱ 해줘야 할듯 그리고 그 값이 애초에 존재하는지 (0보다 큰지) 확인을 해야 함
 */
public class S1_14888_연산자끼워넣기 {
	static int n; // 수의 개수
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] number;
	static int[] operator = new int[4];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 숫자 개수
		number = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(number[0], 0);
		System.out.print(max + "\n" + min);

	}

	static void dfs(int num, int idx) {
		if (idx == n - 1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;

				switch (i) {
				case 0:
					dfs(num + number[idx + 1], idx + 1);
					break;
				case 1:
					dfs(num - number[idx + 1], idx + 1);
					break;
				case 2:
					dfs(num * number[idx + 1], idx + 1);
					break;
				case 3:
					dfs(num / number[idx + 1], idx + 1);
					break;

				}
				operator[i]++;
			}
		}
	}

}
