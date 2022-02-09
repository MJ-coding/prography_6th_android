package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            String bin = Integer.toBinaryString(n);
            for(int i =0; i< bin.length(); i++){
                list.add(Integer.parseInt(bin.substring(i,i+1)));
            }
            Collections.reverse(list);

            while(list.indexOf(1) != -1){
                System.out.print(list.indexOf(1)+" ");
                list.set(list.indexOf(1),0);
            }
        }


    }
}
