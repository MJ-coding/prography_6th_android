package programmers;

import java.util.HashMap;
import java.util.Map;

public class Pro42576 {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"} ,
            new String[] {"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        for(String participantName : participant){
            map.merge(participantName,1,Integer::sum);
        }

        for(String completedName : completion){
            if(map.containsKey(completedName)){
                map.put(completedName , map.get(completedName)-1 );
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){ //참가자수가 남아있으면 answer
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

}
