package algo.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
    static int[][] memoi; // 4개 - 10kg : 0 dummy
    // item[i][0] weight. item[i][i] value
    static int[][] item;
    static int n, k;

    public static void main(String[] args) throws Exception {
        // 모든 item에 대해서 첫 번째 item에서 최선의 결과를 구한 후, 두번째 item에서 첫 번째 item을 고려한 최선의 결과를 비교해서
        // 다시 최선의 결과를 얻는다.
        // 이 과정을 모든 item에 대해서 진행한다.
        // 최선의 결과는 memoi 배열에 기록한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        memoi = new int[n + 1][k + 1];
        item = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                item[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // item
        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= k; w++) {

                // 현재 item이 현재 무게에 선택 가능?
                if (item[i][0] <= w) {
                    // 선택
                    int sel_o = memoi[i - 1][w - item[i][0]] + item[i][1];
                    // 선택 x
                    int sel_x = memoi[i - 1][w];

                    memoi[i][w] = Math.max(sel_o, sel_x);
                } else {
                    memoi[i][w] = memoi[i - 1][w];
                }
            }
        }

        System.out.println(memoi[n][k]);

//        for (int i = 1; i <= n; i++) {
//            System.out.println(Arrays.toString(memoi[i]));
//        }
    }
}