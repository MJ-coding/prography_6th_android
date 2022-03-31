package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,String> map = new HashMap<>();

        while(N-- >0){
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());

            while(num-- > 0){
                String name = br.readLine();
                map.put(name,group);
            }
        }

        while(M-- >0){
            String name = br.readLine();
            int quiz = Integer.parseInt(br.readLine());
            String group = map.get(name);

            if(quiz == 0){
                PriorityQueue<String> pq = new PriorityQueue<>();

                for(Map.Entry<String,String> entry : map.entrySet()){
                    String value = entry.getValue();
                    String key = entry.getKey();

                    if(value.equals(name)){
                        pq.offer(key);
                    }
                }

                while(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                }
            }
            if(quiz == 1){
                sb.append(group).append("\n");
            }
        }

        System.out.println(sb);
    }
}
