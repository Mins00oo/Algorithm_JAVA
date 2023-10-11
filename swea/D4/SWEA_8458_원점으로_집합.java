package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458_원점으로_집합 {
	static int T, N, max;
	static int[] li;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			li = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			li[0] = Math.abs(x) + Math.abs(y);
			
			max = li[0];
			
			boolean stop = false;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				li[i] = Math.abs(x) + Math.abs(y);
				
				max = Math.max(max, li[i]);
				
				if (li[i] % 2 != li[i - 1] % 2) {
					stop = true;
				}
			}
			
			if (stop) {
				sb.append("#").append(t).append(" ").append("-1").append("\n");
				continue;
			}
			// 여기까지 오면 모든 점들이 원점으로부터 거리가 모두 짝수이거나 모두 홀수이거나
			int sum = 0; // 움직이는 거리의 합
			int cnt = 0; // 움직이는 횟수
			
			while (true) {
				if (sum == max || (sum > max) && (sum - max) % 2 == 0) {
					break;
				}
				sum += ++cnt;
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
			
		}
		
		System.out.println(sb);
	}
}






