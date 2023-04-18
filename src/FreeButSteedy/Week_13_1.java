package FreeButSteedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제공자: Programmers
 * 제목: 테이블 해시 함수
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/147354
 * 난이도: Level 2
 * 풀이완료시간: 20분
 * 설명: 이분 탐색 문제 이다. min 과 max 를 정의하는것이 애매하다. 블로그에 있는 해석도 좀...
 */
public class Week_13_1 {

    public static void main(String[] args) {

    }

    static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        List<int[]> dataList = new ArrayList<>(Arrays.asList(data));

        dataList = dataList.stream().sorted((o1, o2) -> {
            if(o1[col-1] > o2[col-1]) {
                return 1;
            } else if(o1[col-1] < o2[col-1]) {
                return -1;
            } else {
                return o2[0] - o1[0];
            }
        }).collect(Collectors.toList());

        for(int i = row_begin-1; i < row_end; i++) {
            int[] element = dataList.get(i);

            int S_i = 0;
            for(int number : element) {
                S_i += (number % (i+1));
            }

            answer ^= S_i;
        }

        return answer;
    }
}
