package programmers.Lv2;

import java.util.Arrays;

public class PGS_N제곱_배열_자르기 {
	
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        
        for(int i = 0; i < answer.length; i++) {
            int row = (int) ((i + left) / n) + 1;
            int col = (int) ((i + left) % n) + 1;
            answer[i] = Math.max(row, col);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Arrays.sort(new PGS_N제곱_배열_자르기().solution(3, 2, 5));
	}
}
