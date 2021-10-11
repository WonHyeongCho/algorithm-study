package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 제공자: Programers
 * 제목: 위장
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42578
 * 설명: 
 */

public class Camouflage {
    public static void main(String[] args) {
        // String[][] clothes = {
        //     {"yellowhat", "headgear"},
        //     {"bluesunglasses", "eyewear"},
        //     {"green_turban", "headgear"}
        // };

        // String[][] clothes = {
        //     {"crowmask", "face"},
        //     {"bluesunglasses", "face"},
        //     {"smoky_makeup", "face"}
        // };

        String[][] clothes = {
            {"abc", "shirt"},
            {"cdf", "face"},
            {"ssc", "face"},
            {"wwwww", "face"},
            {"efg", "eyewear"}
        };

        System.out.println(solution(clothes));
    }

    // 스트림 사용... 뭔말인지 모르겠다.
    // public static int solution(String[][] clothes) {
    //     return Arrays.stream(clothes)
    //             .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
    //             .values()
    //             .stream()
    //             .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    // }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        // 모든 경우의 수 맵에 저장
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 경우의 수 모두 곱함(안입을 경우가 있으므로 +1)
        for(int val : map.values()) {
            answer *= (val + 1);
        }

        // 모두 다 안입는 경우 마지막으로 뺴줌
        return answer - 1;
    }

    /**
     * 메모리 초과, 예외 발생
     * 예외: type --> face ,facegear 등이 있을 경우 contains의 문제
     */
    // public static int solution(String[][] clothes) {
    //     for(int i = 0; i < clothes.length; i++) {
    //         combination(i, clothes[i][0], clothes[i][1], clothes);
    //     }

    //     return map.size();
    // }

    // public static void combination(int start, String cloth, String type, String[][] clothes) {
    //     map.put(cloth, 1); // 시작 옷 넣기

    //     for(int i = start+1; i < clothes.length; i++) {
    //         if(type.contains(clothes[i][1])) {
    //             continue;
    //         }
    //         else {
    //             combination(i, cloth+"|"+clothes[i][0], type+"|"+clothes[i][1], clothes);
    //         }
    //     }
    // }
}
