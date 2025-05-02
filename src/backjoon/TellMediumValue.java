package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 제공자: 백준 제목: 가운데를 말해요
 * URL: https://www.acmicpc.net/problem/1655
 * 난이도: 골드 2
 * 풀이완료시간: 25/40
 * 성공 여부: 실패 -> 시간 초과
 * 설명: 2개 힙을 사용해서 시간 초과를 해결하자.
 * 	1.	새 수가 들어오면, maxHeap에 먼저 넣고
 * 	2.	minHeap의 값보다 큰 수는 minHeap으로 이동
 * 	3.	항상 maxHeap.size() >= minHeap.size()가 되도록 균형 조정
 * 	4.	출력은 maxHeap.peek() → 항상 중간값이 됨
 */
public class TellMediumValue {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 왼쪽 힙 (최대 힙)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 오른쪽 힙 (최소 힙)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // 균형 조정
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // 중간값은 maxHeap의 top
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int first = Integer.parseInt(br.readLine());
//        List<Integer> list = new LinkedList<>();
//        list.add(first);
//        System.out.println(first);
//
//        for(int i = 1; i < N; i++) {
//            int number = Integer.parseInt(br.readLine());
//
//            int index = 0;
//            while(index < list.size()) {
//                if(index == 0) {
//                    if(number < list.get(index)) {
//                        list.add(0, number);
//                        break;
//                    }
//                } else if(list.get(index-1) < number && number < list.get(index)) {
//                    list.add(index, number);
//                    break;
//                } else if (index == list.size() - 1) {
//                    if(list.get(index) < number) {
//                        list.add(number);
//                        break;
//                    }
//                }
//                index++;
//            }
//
//            if(index == list.size()) {
//                list.add(number);
//            }
//
//            int middle = list.size() / 2;
//            if(list.size() % 2 == 0) {
//                middle = middle - 1;
//            }
//            System.out.println(list.get(middle));
//        }
//    }
}
