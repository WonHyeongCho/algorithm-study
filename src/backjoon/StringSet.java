package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

/**
 * 제공자: 백준
 * 제목: 문자열 집합
 * URL: https://www.acmicpc.net/problem/14425
 * 난이도: 실버 4
 * 풀이완료시간: -
 * 성공 여부: -
 * 설명: -
 */
public class StringSet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int N = Integer.parseInt(first.split(" ")[0]);
        int M = Integer.parseInt(first.split(" ")[1]);

        Set<String> set = new java.util.HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            set.add(str);
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(set.contains(str)) count++;
        }

        System.out.println(count);
    }
}
