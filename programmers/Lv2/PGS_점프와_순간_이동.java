package programmers.Lv2;

public class PGS_점프와_순간_이동 {
    public int solution(int n) {
        int ans = 0;
        
        // top-down으로 짝수면 2로나누고 홀수면 -1
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(new PGS_점프와_순간_이동().solution(5)); // 2
		System.out.println(new PGS_점프와_순간_이동().solution(6)); // 2
		System.out.println(new PGS_점프와_순간_이동().solution(5000)); // 5
	}
}
