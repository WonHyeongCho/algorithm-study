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
    static Map<String, Integer> map = new HashMap<>();

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
