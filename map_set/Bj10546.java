package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bj10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0 ; i < N; i++){
            map.merge(br.readLine(),1,Integer::sum);
        }

        for(int i = 1 ; i < N; i++){
            String name = br.readLine();
            if(map.containsKey(name)){
                map.put(name,map.get(name)-1);
            }
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                System.out.println(entry.getKey());
                return;
            }
        }
    }
}
