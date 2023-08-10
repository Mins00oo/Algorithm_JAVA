package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 18개 카드 중에 규영이의 카드 9개 고정되고 나머지 9개 카드의 순서에 따라 승부가 갈라짐
public class SWEA_6808_규영이와인영이의카드게임_np {
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
            while (true) {
                // complete code
                check();
                if (!np(inCard)) break;
            }
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);

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

    static boolean np(int[] array) {
        // 3가지 기억할 것
        // 1. 앞에서 교환되어야 하는 인덱스 & 작업
        int i = array.length - 1;
        // 오름차순이었다가 꺽이는 부분이 생길때까지 반복
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        // 2. 뒤에서 교환되어야 하는 인덱스 & 작업
        int j = array.length - 1;
        while (array[i - 1] >= array[j]) {
            j--;
        }
        // 3. 교환 후 뒤쪽을 작은수로 정리
        swap(array, i - 1, j);

        int k = array.length - 1;
        while (i < k) {
            swap(array, i++, k--);
        }
        // np() 호출 전 보다 바로 다음 큰 수를 만들었음.
        return true;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

