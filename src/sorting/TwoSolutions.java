package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 제공자: 백준
 * 제목: 두 용액
 * URL: https://www.acmicpc.net/problem/2470
 * 난이도: 골드 5
 * 풀이완료시간: 9시51분 PM ~ 10시 31분
 * 성공여부: 실패
 * 설명: 투 포인터 문제... 흠... 좀더 집중해서 풀어야 겠다. 테스트 케이스를 잘 살펴서
 */
public class TwoSolutions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = solution(N, solutions);
        System.out.println(answer[0] + " " + answer[1]);
    }

    static int[] solution(int N, int[] solutions) {
        int[] answer = new int[2];
        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;

        Arrays.sort(solutions);

        while(left < right) {
            System.out.println("left: " + solutions[left]);
            System.out.println("right: " + solutions[right]);
            int sum = solutions[left] + solutions[right];

            if(sum == 0) {
                answer[0] = solutions[left];
                answer[1] = solutions[right];
            }

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = solutions[left];
                answer[1] = solutions[right];
            }

            if(sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }

//    static long[] solution(int N, long[] solutions) {
//        long[] answer = new long[2];
//
//        Arrays.sort(solutions);
//        long min = Long.MAX_VALUE;
//
//        for(int i = 0; i < N; i++) {
//            for(int j = i+1; j < N; j++) {
//                long sum = Math.abs(solutions[i] + solutions[j]);
//
//                if(sum < min) {
//                    min = sum;
//                    answer[0] = solutions[i];
//                    answer[1] = solutions[j];
//                    if(sum == 0) {
//                        return answer;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }
}
