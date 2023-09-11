package bj.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
	static int N, X, sum, max, count = 1;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			sum += arr[i];
			// X-1개만큼 선택했을 때 최댓값으로 합을 설정해두고
			if (i == X - 1) {
				max = sum;
			}
			if (i > X - 1) {
				sum -= arr[i - X];
				if (max < sum) {
					max = sum;
					count = 1;
				} else if (max == sum) {
					count++;
				}
			}
		}

		if (max != 0) {
			System.out.println(max + "\n" + count);
		} else {
			System.out.println("SAD");
		}
	}
}
