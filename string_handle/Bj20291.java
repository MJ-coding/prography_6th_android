package string_handle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj20291 {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n" ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<String,Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());
        while(N-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine(),".");
            String fileName = st.nextToken();
            String extension = st.nextToken();

            map.merge(extension,1,Integer::sum);

        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(SPACE).append(entry.getValue()).append(NEW_LINE);
        }

        System.out.println(sb);
    }

}
