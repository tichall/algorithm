import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();
        
        // 장르별 총 재생횟수 구하기 -> 사실 재생횟수는 순서를 정하는 데에만 사용되기 때문에 
        // 굳이 값을 저장해야 하는지 모르겠긴 함
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            // 키가 없으면 값을 만들어서 넣고, 있으면 그냥 꺼내기
            songsByGenre.computeIfAbsent(genres[i], k -> new ArrayList<>())
                .add(new Song(i, plays[i]));
        }
        
        List<String> genreOrder = new ArrayList<>(map.keySet());
        genreOrder.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));
        List<Integer> album = new ArrayList<>();
        
        for (String genre : genreOrder) {
            List<Song> songs = songsByGenre.get(genre);
            Collections.sort(songs);
            album.add(songs.get(0).getIdx());
                
            if (songs.size() >= 2) {
                album.add(songs.get(1).getIdx());
            }
        }
        
        return album.stream().mapToInt(Integer::intValue).toArray();
    }
    
}

class Song implements Comparable<Song> {
    int idx;
    int play;

    public Song(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song other) {
        if (this.play != other.play) {
            return other.play - this.play;
        }
        return this.idx - other.idx;
    }
    
    public int getIdx() {
        return this.idx;
    }
}