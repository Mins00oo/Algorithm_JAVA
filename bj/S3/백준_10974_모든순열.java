package bj.S3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_10974_모든순열 {
    static int n;
    static int[] src;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = i + 1;
        }
        while (true) {
            for (int s : src) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            if (!np()){
                break;
            }
        }
        System.out.println(sb);
    }

    static boolean np() {
        int i = src.length - 1;
        while (i > 0 && src[i - 1] >= src[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = src.length - 1;
        while (j > i - 1 && src[i - 1] >= src[j]) {
            j--;
        }
        int temp = src[i - 1];
        src[i - 1] = src[j];
        src[j] = temp;

        Arrays.sort(src, i, src.length);
        return true;
    }
}
