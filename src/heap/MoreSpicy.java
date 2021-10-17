package heap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제공자: Programers
 * 제목: 더 맵게
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42626
 * 난이도: Level 2
 * 풀이완료시간: 45분
 * 성공여부: 실패
 * 설명: 리스트로 넣고 빼고 바로 정렬을 하려고 했는데 인덱스 바운드 때문에 런타임 에러가 많이 나고 시간 초과 남
 */
public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        
        System.out.println(solution(scoville, K));
    }

    static int solution(int[] scoville, int K) {
        int answer = 0;

        Arrays.sort(scoville); // 스코필 지수 정렬 
        List<Integer> scovilleList = Arrays.stream(scoville).boxed().collect(Collectors.toList()); // 리스트로 변경

        while(true) {
            // for(int a : scovilleList) {
            //     System.out.print(a + " ");
            // }

            int minScoville = scovilleList.get(0);

            if(minScoville >= K) { 
                return answer;
            }

            int secondMinScoville = scovilleList.get(1);
            scovilleList.remove(0);
            scovilleList.remove(0);

            int newScoville = minScoville + secondMinScoville*2;

            // System.out.println();
            // System.out.println("minScoville: " + minScoville + " secondMinScoville: " + secondMinScoville + " newScoville: " + newScoville);

            answer++; // 횟수 증가
            
            if(scovilleList.size() == 0) { // 모두 섞었을 경우
                if(newScoville >= K) {
                    return answer;
                }
                else {
                    return -1;
                }
            }

            for(int i = 0; i < scovilleList.size(); i++) {
                if(scovilleList.get(i) >= newScoville) {
                    if(newScoville >= K) { // 모든 스코빌이 K 보다 큼
                        return answer;
                    }
                    else {
                        scovilleList.add(i, newScoville);
                        break;
                    }
                }

                if(i == scovilleList.size()) {
                    scovilleList.add(scovilleList.size(), newScoville); // 제일 마지막에 넣기
                }
            }
        }
    }
}
