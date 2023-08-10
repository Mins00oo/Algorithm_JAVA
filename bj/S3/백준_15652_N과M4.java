package bj.S3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15652_N과M4 {
    static int n, m;
    static int[] src;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        src = new int[m];
        dfs(0, 1);
        System.out.println(sb);
    }

    static void dfs(int depth, int x) {
        if (depth == m) {
            // complete code
            for (int s : src) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = x; i <= n; i++) {
            src[depth] = i;
            dfs(depth + 1, i);
        }
    }
}
