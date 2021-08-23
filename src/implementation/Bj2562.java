package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Bj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //key기준으로 정렬
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i =1; i<10; i++){
            map.put(Integer.parseInt(br.readLine()),i);
        }
        System.out.println(map.lastKey());
        System.out.println(map.get(map.lastKey()));


    }
}
