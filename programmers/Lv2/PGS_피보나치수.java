package programmers.Lv2;

public class PGS_피보나치수 {
    static int[] dp = new int[100001];
    
    public int solution(int n) {
        int answer = 0;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i = 3; i <= 100000; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        answer = dp[n] % 1234567;
        return answer;
    }
}
