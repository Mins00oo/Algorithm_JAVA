package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	static int n, m, n_arr[];
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		n_arr = new int[n]; // 들어있는지 확인할려는 대상이기에 받아줄 배열이 필요
		
		for (int i = 0; i < n; i++) {
			n_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Arrays.sort(n_arr); // 이진탐색을 위해서 꼭 정렬을 해줘야 함!!
		
		for (int i = 0; i < m; i++) {
			int k = Integer.parseInt(st.nextToken());
			int search = Arrays.binarySearch(n_arr, k); // 입력값에 따라 k가 배열에 존재하는지 확인하고 있다면 1, 없다면 0
			
			if (search < 0) {
				sb.append(0).append("\n");
			} else {
				sb.append(1).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
