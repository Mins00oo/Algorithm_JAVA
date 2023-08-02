package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 구간의 합을 구하는 문제인데 최대 100,000개의 숫자가 있다.. 그럼 구간도 최대 1에서 100,000까지의 합을 횟수도  최대 100,000인데..
 * 시간초과를 어떻게 해결하지 ? -> 구간의 합을 계속 저장해놓는 식은 어떨지?
 * ex) 1에서 다른 구간으로 까지 가는데 ㄱ걸리는 합을 더해놓는, 자기 자신은 전부 1로 해놓고 -> 아닌거같기도 ..
 * ---해답---
 * 누적합을 구하는 방식이 맞음! 더해나갈때 그냥 처음부터 주어진 곳까지 누적합을 구해놓고 
 * 구해야 하는 구간이 주어지면 그냥 목적지에서 출발점까지의 빼서 그 사이값을 구하면 됨.. 구현만 했으면 됐는데 ㄲㅂ
 * 빼줄 때 출발점은 -1을 해줘야 함 -> 출발지값을 포함해서 끝까지 값을 더하는거라서 -1을 해줘서 값을 추출하면 됨
 */
public class S3_11659_구간합구하기4 {
	static int n; // 수의 개수
	static int m; // 합을 구해야 하는 횟수
	static int[] accu; // 누적합을 기록
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		accu = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) { // 누적합을 구하는 구간
			accu[i] = accu[i - 1] + Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(accu));
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(accu[to] - accu[from - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
