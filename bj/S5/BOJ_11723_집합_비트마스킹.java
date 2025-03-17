package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11723_집합_비트마스킹 {
    static int M;
    static int bitSet = 0; // 비어 있는 공집합 S
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    int addX = Integer.parseInt(st.nextToken());
                    bitSet |= (1 << (addX - 1));
                    break;
                case "remove":
                    int removeX = Integer.parseInt(st.nextToken());
                    bitSet &= ~(1 << (removeX - 1));
                    break;
                case "check":
                    int checkX = Integer.parseInt(st.nextToken());
                    sb.append(((bitSet & (1 << (checkX - 1))) != 0) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    int toggleX = Integer.parseInt(st.nextToken());
                    bitSet ^= (1 << (toggleX - 1));
                    break;
                case "all":
                    bitSet = (1 << 20) - 1; // 20개의 비트를 모두 1로 설정
                    break;
                case "empty":
                    bitSet = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}
