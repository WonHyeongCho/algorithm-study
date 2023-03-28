package stackNqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programers
 * 제목: 프린터
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 * 설명: 
 */

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        
        for(int priority : priorities) { // 큐에 넣는다.
            queue.offer(priority);
        }

        Arrays.sort(priorities); // 우선순위 배열을 정렬
        int size = priorities.length - 1; // 제일 마지막부터 시작ㅎ

        while(!queue.isEmpty()) { // 큐가 비어있을 때 까지
            Integer integer = queue.poll();

            if(integer == priorities[size - answer]) { // 우선순위가 가장 높음
                answer++;
                location--;
                if(location < 0) break; // 내가 원하는 데이터를 추출했음!
            }
            else {
                queue.add(integer);
                location--;
                if(location < 0) location = queue.size() - 1; // 내가 원하는 데이터를 제일 마지막으로 보냄
            }
        }

        return answer;
    }


    /*
    // Order 앤제곱...

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Pair> queue = new LinkedList<Pair>();
        
        int maxPriority = 0;

        for(int i = 0; i < priorities.length; i++) {
            if(maxPriority < priorities[i]) maxPriority = priorities[i];
            queue.offer(new Pair(priorities[i], i));
        }
        
        while(true) {
            Pair pair = queue.poll();
            if(pair.number == location && pair.priority == maxPriority) {
                answer++;
                break;
            }

            if(pair.priority == maxPriority) {
                answer++;
                maxPriority = findMax(queue);
            }
            else {
                queue.add(pair);
            }
        }
    
        return answer;
    }

    public static int findMax(Queue<Pair> queue) {
        int queueSize = queue.size();
        int maxPriority = 0;
        for(int i = 0; i < queueSize; i++) {
            Pair pair = queue.poll();
            if(pair.priority > maxPriority) maxPriority = pair.priority;
            queue.add(pair);
        }

        return maxPriority;
    }

    public static class Pair {
        int priority;
        int number;

        public Pair(int priority, int number) {
            this.priority = priority;
            this.number = number;
        }
    }
    */
}
