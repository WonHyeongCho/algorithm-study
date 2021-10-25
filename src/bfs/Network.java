package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programers
 * 제목: 네트워크
 * URL: https://programmers.co.kr/learn/courses/30/lessons/43162
 * 난이도: Level 3
 * 풀이완료시간: 21분/45분
 * 성공여부: 성공
 * 설명: 
 */
public class Network {
    public static void main(String[] args) {
        int n = 3;
        // int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computers));
    }

    static int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> visit = new LinkedList<>(); // 방문 한 큐
        int[] check = new int[computers.length]; // 방문했는지 알기 위한 배열

        for(int i = 0; i < n; i++) {
            if(check[i] != 1) { // 현재 내 위치 방문하지 않은 경우
                check[i] = 1;
                visit.add(i);
                while(!visit.isEmpty()) {
                    int current = visit.poll();
                    for(int j = 0; j < n; j++) {
                        if(j == current) {
                            continue;
                        }

                        if(computers[current][j] == 1 && check[j] != 1) { // 연결되어 있고 방문하지 않은 경우
                            visit.add(j);   // 방문 큐에 넣기
                            check[j] = 1;   // 방문 했다고 체크
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}
