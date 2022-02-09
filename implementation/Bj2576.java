package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int num;
        int sum = 0;
        for(int i=0; i<7; i++){
            num =Integer.parseInt(br.readLine());
            if(num%2 != 0){
                list.add(num);
            }
        }
        if(list.size() !=0){
            for(int n : list){
                sum += n;
            }
            Collections.sort(list);
            System.out.println(sum);
            System.out.print(list.get(0));
        }else{
            System.out.print(-1);
        }
    }
}
