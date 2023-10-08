package programmers.Lv2;

/*
 */
public class PGS_숫자의표현 {
	
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = i; j <= n; j++) {
				sum += j;
				
				if (sum == n) {
					answer++;
				} else if (sum > n) {
					break;
				}
			}
		}
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(new PGS_숫자의표현().solution(15));
	}
}