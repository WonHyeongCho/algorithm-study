package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 제공자: Programers
 * 제목: 베스트 앨범
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42579
 * 난이도: Level 3
 * 풀이완료시간: 30분
 * 성공여부: 실패
 * 설명: 스트림 너무 어렵다... 알고리즘에서 스트림 쓰는게 맞나? 속도는??
 */
public class BestAlbum {
    public static void main(String[] args) {
        // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        // int[] plays = {500, 600, 150, 800, 2500};

        String[] genres = {"classic", "pop", "kpop", "pop", "jpop", "classic", "kpop", "kpop"};
        int[] plays = {7000, 200, 250, 400, 800, 1000, 200, 10};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    static int[] solution(String[] genres, int[] plays) {
        Map<String, GenreInfo> genresMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            if(genresMap.containsKey(genre)) { // 이미 등록되어 있는 경우
                registerMusic(genresMap.get(genre), i, plays);
            }
            else {
                genresMap.put(genre, new GenreInfo(plays[i], i));
            }
        }

        List<Integer> answerList = new ArrayList<>();

        genresMap.entrySet().stream()
            // .sorted(Comparator.comparing((GenreInfo genre) -> genre.play).reversed())
            .sorted(Entry.comparingByValue(Comparator.comparing(GenreInfo::getPlay).reversed()))
            .forEach(genresMapEntity -> {
                GenreInfo genresInfo = genresMapEntity.getValue();
                answerList.add(genresInfo.firstIndex);
                if(genresInfo.secondIndex != -1) {
                    answerList.add(genresInfo.secondIndex);
                }
            });
            // .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        int[] answer = new int[answerList.size()];

        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    static void registerMusic(GenreInfo genresInfo, int index, int[] plays) { // 장르 정보에 뮤직 더하기
        genresInfo.play += plays[index];

        if(genresInfo.secondIndex == -1) { // 두번째가 아직 등록되지 않은 경우
            if(plays[genresInfo.firstIndex] < plays[index]){
                genresInfo.secondIndex = genresInfo.firstIndex;
                genresInfo.firstIndex = index;
            }
            else {
                genresInfo.secondIndex = index;
            }
            return;
        }

        if(plays[genresInfo.secondIndex] < plays[index]) { // 같은 경우는 확인할 필요 없음, 고유번호대로 for문을 돌아 등록하기 떄문
            if(plays[genresInfo.firstIndex] < plays[index]) {
                genresInfo.secondIndex = genresInfo.firstIndex;
                genresInfo.firstIndex = index;
            }
            else {
                genresInfo.secondIndex = index;
            }
        }
    }

    static class GenreInfo {
        int play; // 플레이 횟수
        int firstIndex; // 첫번째 인덱스
        int secondIndex; // 두번째 인덱스

        GenreInfo(int play, int firstIndex) {
            this.play = play;
            this.firstIndex = firstIndex;
            this.secondIndex = -1;
        }

        int getPlay() {
            return play;
        }
    }
}
