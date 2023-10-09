package programmers.Lv2;

public class PGS_다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        int oneCnt = 0;
        String binary = Integer.toBinaryString(n);
        
        for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				oneCnt++;
			}
		}
        
        for (int i = n + 1; i <= 1000000; i++) {
			String Ibinary = Integer.toBinaryString(i);
			int iCnt = 0;
			for (int j = 0; j < Ibinary.length(); j++) {
				if (Ibinary.charAt(j) == '1') {
					iCnt++;
				}
			}
			
			if (iCnt == oneCnt) {
				answer = i;
				break;
			}
		}
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(new PGS_다음큰숫자().solution(78));
	}
}
