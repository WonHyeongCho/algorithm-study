package kakao;

public class UndamagedBuilding {

    public static void main(String[] args) {
        int[][] board = {
            {5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}
        };
        int[][] skill = {
            {1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}
        };
        System.out.println(solution(board, skill));
    }

    // 문제를 누적합으로 해결한다.
    static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int N = board[0].length;
        int M = board.length;

        int[][] recordMap = new int[M+1][N+1];

        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0] == 1 ? -1 : 1; // 1이면 공격 아니면 회복
            int value = skill[i][5] * type; // 데미지 or 회복 값

            // 시작점과 끝 점을 계산해야 할 값으로 표시
            recordMap[skill[i][1]][skill[i][2]] += value;
            recordMap[skill[i][3]+1][skill[i][4]+1] += value;

            // 누적합의 마지막을 표시
            recordMap[skill[i][1]][skill[i][4]+1] += value * -1;
            recordMap[skill[i][3]+1][skill[i][2]] += value * -1;
        }

        for(int i = 0; i < recordMap.length; i++) {
            for (int j = 0; j < recordMap[0].length; j++) {
                System.out.print(recordMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        // 이전 원소랑 현재 원소를 합
        // 가로로 누적합 계산
        for(int[] r : recordMap) {
            for(int i = 1; i < N; i++) {
                r[i] += r[i-1];
            }
        }

        // 세로로 누적합 계산
        for(int i = 0; i < N; i++) {
            for(int j = 1; j < M; j++) {
                recordMap[j][i] += recordMap[j-1][i];
            }
        }

        for(int i = 0; i < recordMap.length; i++) {
            for (int j = 0; j < recordMap[0].length; j++) {
                System.out.print(recordMap[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] += recordMap[i][j];
                if(board[i][j] > 0) answer++;
            }
        }

        System.out.println();

        return answer;
    }
}
