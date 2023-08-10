package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트_dfs버전 {
    static int T, N, L, max;
    static int[][] src;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            src = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                src[i][0] = Integer.parseInt(st.nextToken());
                src[i][1] = Integer.parseInt(st.nextToken());
            }

            // 부분집합
            dfs(0, 0, 0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int srcIdx, int point, int cal) {
        if (srcIdx == N) {
            // complete code
            System.out.println("point = " + point);
            max = Math.max(max, point); // L 조건을 따지지 않고 이전에 미리 가지치기를 함
            return;
        }
        dfs(srcIdx + 1, point, cal); // 이전에 전달받은 point와 cal를 그대로 전달
        // 가지치기 -> 다음 재귀호출의 cal가 이미 L을 초과하면 가지 않도록
        int nextCal = cal + src[srcIdx][1];
        if (nextCal <= L) {
            dfs(srcIdx + 1, point + src[srcIdx][0], nextCal); // 선택
        }
    }
}
