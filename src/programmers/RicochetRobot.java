package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programmers
 * 제목: 리코쳇 로봇
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/169199
 * 난이도: Level 2
 * 풀이완료시간: /40분
 * 성공 여부: 실패
 * 설명:
 */
public class RicochetRobot {

    public static void main(String[] args) {
//        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board = {".D.R", "....", ".G..", "...D"};
        System.out.println(solution(board));
    }

    // 시간 초과 실패, 이전에 방문했다는 곳을 표시해줘야함
    static int solution(String[] board) {
        int m = board.length;
        int n = board[0].length();

        // 상 하 좌 우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        char[][] map = new char[m][n];

        // 0: y, 1: x
        int[] currentR = new int[3];
        int[] G = new int[2];

        int row = 0;

        // Map 초기화
        for(String str : board) {
            for(int i = 0; i < n; i++) {
                char c = str.charAt(i);

                if(c == 'R') {
                    currentR[0] = row;
                    currentR[1] = i;
                } else if(c == 'G') {
                    G[0] = row;
                    G[1] = i;
                }

                map[row][i] = c;
            }
            row++;
        }

        boolean isPossible = false;

        for(int i = 0; i < 4; i++) {
            int[] next = new int[2];
            next[0] = G[0] + dy[i];
            next[1] = G[1] + dx[i];

            if(next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n || map[next[0]][next[1]] == 'D') {
                isPossible = true;
                break;
            }
        }

        if(!isPossible) return -1;

        // BFS로 풀기
        Queue<int[]> queue = new LinkedList<>();
        queue.add(currentR);

        do {
            int[] current = queue.poll();

            // 상 하 좌 우 로 이동
            for(int i = 0; i < 4; i++) {
                int[] next = new int[]{current[0], current[1], current[2]+1};
                System.out.println("next: " + Arrays.toString(next));
                while(true) {
                    System.out.println("y: " + next[0] + ", x: " + next[1] + ", i: " + i);

                    next[0] += dy[i];
                    next[1] += dx[i];

                    // 맵 밖이거나 장애물이면 이전 위치를 큐에 등록
                    if(next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n || map[next[0]][next[1]] == 'D') {
                        break;
                    }
                }

                if(map[next[0]-dy[i]][next[1]-dx[i]] == 'G') {
                    return next[2];
                } else {
                    queue.add(new int[]{next[0]-dy[i], next[1]-dx[i], next[2]});
                }
            }
        } while(!queue.isEmpty());

        return -1;
    }
}
