package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제공자: 백준
 * 제목: 운동
 * URL: https://www.acmicpc.net/problem/1956
 * 난이도: 골드 4
 * 풀이완료시간: -
 * 성공 여부: -
 * 설명: 플로이드 워셜로 풀기
 */
public class Problem1956 {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V + 1][V + 1];

        // 초기화
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        // 플로이드 워셜
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // 사이클 찾기
        int minCycle = INF;
        for (int i = 1; i <= V; i++) {
            if (dist[i][i] < minCycle) {
                minCycle = dist[i][i];
            }
        }

        System.out.println(minCycle == INF ? -1 : minCycle);
    }
}