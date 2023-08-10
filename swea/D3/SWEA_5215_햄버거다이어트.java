package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {
    static int[] taste, kal;
    static boolean[] select;
    static int T, n, l;
    static StringTokenizer st;
    static int max_taste;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 1
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 5
            l = Integer.parseInt(st.nextToken()); // 1000
            taste = new int[n];
            kal = new int[n];
            select = new boolean[n];
            max_taste = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                kal[i] = Integer.parseInt(st.nextToken());
            }
            subset(0);
            sb.append("#").append(t).append(" ").append(max_taste).append("\n");
        }
        System.out.println(sb);
    }

    static void subset(int idx) {
        if (idx == n) {
            printSubset();
            return;
        }
        select[idx] = true;
        subset(idx + 1);
        select[idx] = false;
        subset(idx + 1);
    }

    static void printSubset() {
        int sum = 0;
        int taste_sum = 0;
        for (int i = 0; i < n; i++) {
            if (select[i]) {
                sum += kal[i];
                taste_sum += taste[i];
            }
        }
        if (sum <= l) {
            max_taste = Math.max(max_taste, taste_sum);
        }
    }
}
