package inflearn;

import java.util.Scanner;

/**
 * 제공자: 인프런 - 자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비
 * 제목: ㄷㅐㅅㅗㅁㅜㄴㅈㅏ ㅂㅕㄴㅎㅗㅏㄴ
 * URL: https://cote.inflearn.com/contest/10/problem/01-02
 * 난이도: 초급
 * 풀이완료시간:
 * 성공여부:
 * 설명:
 *
 */
public class CaseConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        System.out.println(solution(str));
    }

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()) {
//            if(c <= 90) {
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            }
            else {
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.toString();
    }
}
