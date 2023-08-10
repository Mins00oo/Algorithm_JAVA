package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트_피드백 {
    static int T, N, L, max;
    static Item[] src;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            src = new Item[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // 부분집합
            subset(0, 0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void subset(int srcIdx, int mask) {
        if (srcIdx == N) {
            // complete code
            int cal = 0;
            int point = 0;

            // 선택된 재료에 있어 맛과 칼로리의 합
            for (int i = 0; i < N; i++) {
                if ((mask & 1 << i) == 0) {
                    continue;
                }
                cal += src[i].c;
                point += src[i].p;
            }

            // cal가 제한을 넘지 않을때 max 확인
            if (cal <= L) {
                max = Math.max(mask, point);
            }
            return;
        }
        subset(srcIdx + 1, mask | 1 << srcIdx); // 선택
        subset(srcIdx + 1, mask); // 비선택
    }

    static class Item {
        int p, c;

        public Item(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
}
