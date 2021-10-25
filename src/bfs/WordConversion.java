package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 제공자: Programers
 * 제목: 단어 변환
 * URL: https://programmers.co.kr/learn/courses/30/lessons/43163
 * 난이도: Level 3
 * 풀이완료시간: 35분/45분
 * 성공여부: 성공
 * 설명: 음.. 객체를 써서 체크 배열을 계속 복사하긴 하는데 메모리를 많이 쓸까?
 */
public class WordConversion {
    public static void main(String[] args) {
        String begin = "hit";
        String targer = "cog";
        // String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, targer, words));
    }

    static int solution(String begin, String target, String[] words) {
        Queue<WordRecord> strQueue = new LinkedList<>();

        for(int i = 0; i < words.length; i++) { // 처음 초기화
            if(isChangable(begin, words[i])) {
                if(words[i].equals(target)) {
                    return 1;
                }

                WordRecord wordRecord = new WordRecord(words[i], words.length, i);
                strQueue.add(wordRecord);
            }
        }

        while(!strQueue.isEmpty()) {
            WordRecord wordRecord = strQueue.poll();

            for(int i = 0; i < words.length; i++) {
                if(!wordRecord.check[i] && isChangable(wordRecord.word, words[i])) { // 방문하지 않았고 변할 수 있으면
                    if(words[i].equals(target)) {   // 변환한 워드가 타겟이면
                        return wordRecord.layer+1;
                    }

                    strQueue.add(new WordRecord(words[i], wordRecord.layer+1, Arrays.copyOf(wordRecord.check, wordRecord.check.length), i));
                }
            }
        }

        return 0;
    }

    static boolean isChangable(String str1, String str2) {
        int count = 0;

        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) == str2.charAt(i)) count++;
        }

        if(count == str1.length()-1) {
            return true;
        }
        else {
            return false;
        }
    }

    static class WordRecord {
        String word;
        int layer;
        boolean[] check;

        WordRecord(String word, int layer, boolean[] check, int index) {
            this.word = word;
            this.layer = layer;
            this.check = check;
            this.check[index] = true;
        }

        WordRecord(String word, int size, int index) {
            this.word = word;
            this.layer = 1;
            this.check = new boolean[size];
            this.check[index] = true;
        }
    }
}
