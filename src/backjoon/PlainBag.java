package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 제공자: 백준
 * 제목: 평범한 가방
 * URL: https://www.acmicpc.net/problem/12865
 * 난이도: 골드 5
 * 풀이완료시간: 40/40분
 * 성공 여부: 실패
 * 설명:
 */
public class PlainBag {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int N = Integer.parseInt(first.split(" ")[0]);
        int K = Integer.parseInt(first.split(" ")[1]);
        int[][] bags = new int[N][2];

        for (int i = 0; i < N; i++) {
            String bag = br.readLine();
            bags[i] = Arrays.stream(bag.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solution(N, K, bags);
    }

    /**
     * 그리디 방식으로 풀었는데 다음과 같은 반례가 존재함.
     * N = 4, K = 3
     * 아이템들:
     * 1) 무게 1, 가치 2
     * 2) 무게 1, 가치 2
     * 3) 무게 1, 가치 3
     * 4) 무게 2, 가치 3
     * 0-1 Knapsack 문제는 DP로 해결해야함
     */
    static void solution(int N, int K, int[][] bags) {
        int[][] sorted = Arrays.stream(bags).sorted((o1, o2) -> {
            if(o2[1] > o1[1]) {
                return 1;
            } else if(o2[1] == o1[1]) {
                if(o2[0] < o1[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
            else {
                return -1;
            }
        }).toArray(int[][]::new);

//        for(int i = 0; i < sorted.length; i++) {
//            System.out.println(Arrays.toString(sorted[i]));
//        }


        int startIndex = 0;
        int weight = 0;
        int value = 0;
        int maxValue = 0;

        while (startIndex < N) {
//            System.out.println("***** Starting index: " + startIndex + " *****");
            for (int i = startIndex; i < N; i++) {
                int nextWeight = weight + sorted[i][0];
                if(nextWeight <= K) {
                    weight = nextWeight;
                    value += sorted[i][1];
//                    System.out.printf("Put, weight: %d, value %d\n", weight, value);
                }
            }

            if(value > maxValue) {
                maxValue = value;
            }

//            System.out.println("***** Ending Value: " + value + " *****");
            weight = 0;
            value = 0;
            startIndex++;
        }

        System.out.println(maxValue);
    }
}
