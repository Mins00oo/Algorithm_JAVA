package swea.모의테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_보물상자비밀번호 {
	static int T, N, K;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			String hexNums = br.readLine();
			int oneSize = N / 4; // 이만큼 반복횟수
			
			for (int i = 0; i < oneSize; i++) {
				int start = 0;
				int end = oneSize; // 테케 1 -> 3
				
				for (int j = 0; j < 4; j++) {
					String hex = hexNums.substring(start, end);
					int num = Integer.parseInt(hex, 16);
					// 중복 제거 
					if (!list.contains(num)) {
						list.add(num);
					}
					start = end;
					end += oneSize;
				}
				
				System.out.println(list);
				
				// 맨 뒤에 글자를 자르고
				char c = hexNums.charAt(N - 1);
				// 맨 앞으로 이동시킨 후에 자르는 것을 반복
				hexNums = c + hexNums.substring(0, N -1);
			}
			
			Collections.sort(list);
			sb.append("#").append(t).append(" ").append(list.get(list.size() - K)).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	
}











