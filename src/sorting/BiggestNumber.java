package sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 제공자: Programers
 * 제목: 가장 큰 수
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42746
 * 설명: 
 */

public class BiggestNumber {
    public static void main(String[] args) {
        // int[] numbers = new int[]{6, 10, 2};

        // int[] numbers = new int[]{3, 30, 34, 5, 9};

        int[] numbers = new int[]{0, 0, 0, 0, 0};

        System.out.println(solution(numbers));
    }

    static String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        String answer = Arrays.stream(strNumbers).sorted((a, b) -> { // 직접 합쳐 비교한다.
            return (a+b).compareTo(b+a)*-1;
        })
        .collect(Collectors.joining());
        
        if(answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}


