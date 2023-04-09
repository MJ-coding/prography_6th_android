package programmers;
// 배스트 앨범

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Pro42579 {

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
            new int[] {500, 600, 150, 800, 2500});

        for(int ans : answer){
            System.out.print(ans + " ");
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        //1. totalPlays 2. plays 순으로 정렬 -> num 출력
        int size = genres.length;
        int[] answer ;
        HashMap<String, Integer> map = new HashMap<>(); //totalPlays
        HashMap<String, Integer> limitMap = new HashMap<>(); //2개씩 limit
        List<Album> list = new ArrayList<>(); //sorting Album
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0 ; i < size; i++){
            map.merge(genres[i],plays[i],Integer::sum);
        }

        for(int i = 0 ; i < size ; i++){
            list.add(new Album(i,genres[i],plays[i],map.get(genres[i])));
        }
        Comparator<Album> albumComparator = Comparator.comparing(Album::getPlay).reversed();
        list.sort(Comparator.comparing(Album::getTotalPlay).reversed().thenComparing(albumComparator));

        for(Album album : list){
            limitMap.merge(album.getGenre(),1,Integer::sum);
            if(limitMap.get(album.getGenre()) <= 2){
                answerList.add(album.getNum());
            }
        }

        answer = new int[answerList.size()];
        int i = 0;
        for(int ans : answerList){
            answer[i++] = ans;
        }

        return answer;
    }

}
class Album{
    int num;
    String genre;
    int play;
    int totalPlay;

    public Album(int num, String genre, int play, int totalPlay) {
        this.num = num;
        this.genre = genre;
        this.play = play;
        this.totalPlay = totalPlay;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public int getPlay() {
        return play; //ASC
    }

    public int getTotalPlay() {
        return totalPlay;
    }

    public String getGenre() {
        return genre;
    }
}
