package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
	static int N, d, k, c; // 접시의 수, 가짓수, 접시의 수, 쿠폰 번호
	static int[] sushi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < k + i; j++) {
				// j가 sushi배열의 범위 밖으로 가면 다시 맨 앞으로 와서 넣어주고
				
			}
		}
	}
}
