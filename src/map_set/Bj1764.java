package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1764 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int id = 1;

        List<String> answer = new ArrayList<>();
        Map<String,Integer> listenList = new HashMap<>();
        for(int i = 0; i< N; i++){
            listenList.put(br.readLine(),id++);
        }
        for(int i = 0; i< M; i++){
            String showName = br.readLine();
            if(listenList.containsKey(showName)) answer.add(showName);
        }

        Collections.sort(answer);
        sb.append(answer.size()).append(NEW_LINE);
        for(String name : answer){
            sb.append(name).append(NEW_LINE);
        }
        System.out.println(sb);
    }
}
