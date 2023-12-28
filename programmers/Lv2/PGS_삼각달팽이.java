package programmers.Lv2;

public class PGS_삼각달팽이 {
    public int[] solution(int n) {
        // 전체 개수는 1 + 2 + 3 +... + n개
        int[] answer = new int[(n * (n + 1)) / 2];
        // n * n 형태의 삼각형으로 나타내기 위함
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1; // 시작점

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++; // 아래로 움직인다
                } else if (i % 3 == 1) {
                    y++; // 오른쪽으로 움직인다
                } else if (i % 3 == 2) {
                    x--; // 왼쪽 위 대각선으로 움직인다
                    y--;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 0이 나오면 바로 다음 행으로
                if (matrix[i][j] == 0)
                    break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        new PGS_삼각달팽이().solution(4);
    }
}
