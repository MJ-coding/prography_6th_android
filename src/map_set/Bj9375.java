package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bj9375 {
    private static final String NEW_LINE = "\n";
    private static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            Map<String,Integer>  map = new HashMap<>();

            for(int i = 0; i < N; i++){
                String[] input = br.readLine().split(" ");
                String category = input[1];
//                if(map.containsKey(category)){
//                    map.put(category, map.get(category)+1);
//                }else{
//                    map.put(category,1);
//
//                }
                map.merge(category,1,Integer::sum);
            }
            map.values().forEach((value) -> answer *= (value+1));
            sb.append(answer-1).append(NEW_LINE);
            answer = 1;
        }
        System.out.println(sb);
    }
}
