import java.util.*;
class Solution {
    static class Play {
        int idx;
        int cnt;
        public Play(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
        public int getIdx() {
            return this.idx;
        }
        public int getCnt() {
            return this.cnt;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, List<Play>> gMap = new HashMap<>(); // 장르별 고유번호, 재생횟수 관리
        Map<String, Integer> pMap = new HashMap<>(); // 장르별 총 재생횟수 관리
        for(int i = 0; i < genres.length; i++) {
            // 해당 장르의 key가 존재하지 않으면 새 리스트에 생성하여 추가, 있으면 기존값에 추가
            gMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Play(i, plays[i]));
            pMap.merge(genres[i], plays[i], Integer::sum);
        }

        // 총 재생횟수 내림차순 정렬 한 장르
        List<String> pMapKeyset = new ArrayList<>(pMap.keySet());
        pMapKeyset.sort((a, b) -> pMap.get(b).compareTo(pMap.get(a)));
        
        ArrayList<Integer> ansList = new ArrayList<>();
        for(String g : pMapKeyset) {
            List<Play> nPlay = gMap.get(g);
            // 재생횟수 내림차순 정렬, 동일 횟수일 때 고유 번호 오름차순 정렬
            nPlay.sort(Comparator
                             .comparing(Play::getCnt, Comparator.reverseOrder())
                             .thenComparing(Play::getIdx));
            
            // 최대 2개의 노래
            for(int i = 0; i < Math.min(2, nPlay.size()); i++) {
                ansList.add(nPlay.get(i).getIdx());
                System.out.printf("%s:: idx: %d, cnt: %d\n", g, nPlay.get(i).getIdx(), nPlay.get(i).getCnt());
            }
        }        
        answer = ansList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}