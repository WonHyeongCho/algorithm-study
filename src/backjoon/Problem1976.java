package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제공자: 백준
 * 제목: 여행 가자
 * URL: https://www.acmicpc.net/problem/1976
 * 난이도: 골드 4
 * 풀이완료시간: 40/40
 * 성공 여부: 실패
 * 설명: 유니온 파인드(Disjoint Set) 풀이
 */
public class Problem1976 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N+1]; // 부모 저장 배열
        for (int i = 1; i <= N; i++) {
            parents[i] = i; // 자기 자신을 대표로 지정
        }

        // 그룹을 만들어 놓음
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int connect = Integer.parseInt(st.nextToken());
                if(connect == 1 ) {
                    union(i, j);
                }
            }
        }

        int[] trip = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            trip[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;
        int root = find(trip[0]);
        for(int i = 1; i < M; i++) {
            if (find(trip[i]) != root) { // 같은 그룹이 아닐 경우
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    static int find(int a) { // 부모 찾기
        if(parents[a] != a) {
            parents[a] = find(parents[a]); // 최적화를 통해 다음 연산시에는 바로 부모를 찾을수 있도록 변경
        }
        return parents[a];
    }

    static void union(int a, int b) { // 2개의 그룹을 합침
        a = find(a);
        b = find(b);
        if(a != b) {
            parents[b] = a;
        }
    }
}
