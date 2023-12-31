package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {
	static int N, M, T;
	static int[][] arr;
	static int[][] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			check = new int[N][N];
			int ans = 0;
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(arr[i], 100000000);
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a - 1][b - 1] = 1;
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == j) {
							continue;
						}
						if (arr[i][k] == 1 && arr[k][j] == 1) {
							arr[i][j] = 1;
							check[i][j] = 1;
							check[i][k] = 1;
							check[k][i] = 1;
							check[k][j] = 1;
							check[j][i] = 1;
							check[j][k] = 1;
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (check[i][j] == 1) {
						sum++;
					}
				}
				if (sum == N - 1) {
					ans++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);

	}
}






