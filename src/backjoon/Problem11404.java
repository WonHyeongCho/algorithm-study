package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제공자: 백준
 * 제목: 플로이드
 * URL: https://www.acmicpc.net/problem/11404
 * 난이도: 골드 4
 * 풀이완료시간: 37/40
 * 성공 여부: 성공
 * 설명: -
 */
public class Problem11404 {
    static int max = 100_000 * (100-1) + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] w = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++) {
            Arrays.fill(w[i], max);
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            w[a][b] = Math.min(weight, w[a][b]);
        }
        solution(N, w);
    }

    static void solution(int N, int[][] w) {
        for(int k = 1; k < N + 1; k++) {
            for(int i = 1; i < N + 1; i++) {
                for(int j = 1; j < N + 1; j++) {
                    if(i != j) {
                        w[i][j] = Math.min(w[i][k] + w[k][j], w[i][j]);
                    }
                }
            }
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                if(w[i][j] == max) {
                    System.out.print("0 ");
                } else {
                    System.out.print(w[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
