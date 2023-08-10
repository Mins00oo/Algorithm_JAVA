package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 18개 카드 중에 규영이의 카드 9개 고정되고 나머지 9개 카드의 순서에 따라 승부가 갈라짐
public class SWEA_6808_규영이와인영이의카드게임_swap {
    static int T, win, lose, n = 9;
    static int[] input = new int[19];
    static int[] guCard = new int[9];
    static int[] inCard = new int[9]; // 인영이의 카드
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            win = 0;
            lose = 0;
            Arrays.fill(input, 0);
            // 입력처리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = 0;
            for (int i = 0; i < n; i++) {
                num = Integer.parseInt(st.nextToken());
                input[num] = 1;
                guCard[i] = num;
            }
            num = 0;
            for (int i = 1; i < 19; i++) {
                if (input[i] == 0) {
                    inCard[num++] = i;
                }
            }
            perm(0);
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);

    }

    static void perm(int srcIdx) {
        if (srcIdx == n) {
            check();
            return;
        }
        // i는 srcIdx부터 (자기 자신 포함)
        for (int i = srcIdx; i < inCard.length; i++) {
            // i와 srcIdx를 교환
            int temp = inCard[srcIdx];
            inCard[srcIdx] = inCard[i];
            inCard[i] = temp;

            perm(srcIdx + 1);
            // i와 srcIdx 교환 원복
            temp = inCard[srcIdx];
            inCard[srcIdx] = inCard[i];
            inCard[i] = temp;
        }
    }

    static void check() {
        int guSum = 0;
        int inSum = 0;
        for (int i = 0; i < n; i++) {
            if (guCard[i] > inCard[i]) {
                guSum += guCard[i] + inCard[i];
            } else {
                inSum += guCard[i] + inCard[i];
            }
        }
        if (guSum > inSum) {
            win++;
        } else {
            lose++;
        }
    }
}

