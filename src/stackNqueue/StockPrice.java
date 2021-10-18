package stackNqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programers
 * 제목: 주식 가격
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42584
 * 난이도: Level 2
 * 풀이완료시간: 45분 시간제한, 60분
 * 성공여부: 실패
 * 설명: 배열을 큐에 넣어서 많이 햇갈렸다... 햇갈리지 않게 잘 넣어야겠다.
 */
public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices)));
    }

    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{prices[0], 0}); // 가격, 순서

        for(int i = 1; i < prices.length; i++) {
            int queueSize = queue.size();

            for(int j = 0; j < queueSize; j++) { // 현재 queue 사이즈 만큼 검사
                int[] priceInfo = queue.poll();
                // System.out.println(Arrays.toString(priceInfo));

                if(priceInfo[0] > prices[i])  { // 현재 가격보다 작으면
                    answer[priceInfo[1]] = i-priceInfo[1];
                }
                else { // 안 작으면 다시 넣기
                    queue.add(priceInfo); 
                }
            }

            // System.out.println("Input: " + Arrays.toString(new int[]{prices[i], i}));
            // System.out.println();
            queue.add(new int[]{prices[i], i});
        }

        // System.out.println(Arrays.toString(answer));
        
        while(!queue.isEmpty()) { // queue 비워주기
            int[] priceInfo = queue.poll();
            answer[priceInfo[1]] = answer.length - priceInfo[1] - 1; 
        }

        return answer;
    }
}