package inflearn;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 제공자: 인프런 - 자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비
 * 제목: 문장 속 단어
 * URL: https://cote.inflearn.com/contest/10/problem/01-03
 * 난이도: 초급
 * 풀이완료시간:
 * 성공여부:
 * 설명:
 *
 */
public class WordsInASentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(solution(scanner.nextLine()));
    }

    private static String solution(String str) {
        String[] split = str.split(" ");

        String answer = split[0];

        for(int i = 1; i < split.length; i++) {
            if(split[i].length() > answer.length()) answer = split[i];
        }

        return answer;
    }
}
