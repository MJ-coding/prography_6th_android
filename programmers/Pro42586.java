package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Pro42586 {

    public static void main(String[] args) {
        int[] answer = new int[2];
        answer = solution(new int[] {93, 30, 55}, new int[]{1, 30, 5});
        for(int i = 0 ; i < 2; i++){
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        HashMap<Integer, Integer> map = new HashMap<>();
        int proSize = progresses.length;
        int[] day = new int[proSize];

        for(int i = 0 ; i < proSize ; i++){
            day[i] = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i] != 0)
                day[i]++;
        }

        for(int i = 0 ; i < proSize-1 ; i++){
            day[i+1] = day[i] > day[i+1] ? day[i] : day[i+1];
        }

        for(int i = 0 ; i < proSize ; i++){
            map.merge(day[i],1,Integer::sum);
        }
        answer = new int[map.size()];
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        int index = 0;
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() != 0) {
//                answer[index] = entry.getValue();
//                index++;
//            }
//        }
        for(Map.Entry<Integer, Integer> l :list){
            answer[index++] = l.getValue();
        }
        return answer;

    }

}
