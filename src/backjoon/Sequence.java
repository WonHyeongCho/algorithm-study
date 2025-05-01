package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제공자: 백준
 * 제목: 문자열 집합
 * URL: https://www.acmicpc.net/problem/2559
 * 난이도: 실버 4
 * 풀이완료시간: -
 * 성공 여부: -
 * 설명: -
 */
public class Sequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int N = Integer.parseInt(first.split(" ")[0]);
        int K = Integer.parseInt(first.split(" ")[1]);
        String[] numbers = br.readLine().split(" ");
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        solution(N, K, arr);
    }

    static void solution(int N, int K, int[] arr) {
        int max = 0;
        for(int i = 0; i < K; i++) {
            max += arr[i];
        }
        int aggregate = max;

        for(int i = 1; i < N - K + 1; i++) {
            int sum = aggregate - arr[i - 1] + arr[i + K - 1];
            max = Math.max(max, sum);
            aggregate = sum;
        }

        System.out.println(max);
    }
}
