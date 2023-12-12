package programmers.Lv2;

public class PGS_프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock(m, n, map);
            // 지울 블록이 없으면 중단
            if (cnt == 0) break;
            answer += cnt;
            // 블록 내려주고
            dropBlock(m, n, map);
        }
        return answer;
    }

    private void dropBlock(int m, int n, char[][] map) {
        // 블록 내려주기
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '.') {
                            // 블록을 만났을 경우 스왑
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private int checkBlock(int m, int n, char[][] map) {
        // 지울 블록의 개수 확인
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == '.') continue;
                checkFour(map, isChecked, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isChecked[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }

        return cnt;
    }

    private void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
        char block = map[i][j];

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                if (map[r][c] != block) return;
            }
        }

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                isChecked[r][c] = true;
            }
        }
    }
}
