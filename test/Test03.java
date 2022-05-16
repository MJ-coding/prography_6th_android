package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Test03 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int solution(int n, int[][] battery) {
        int answer = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < battery.length; i++){
            for(int j = 0 ; j < 2; j++){
                map.put(battery[i][0],battery[i][1]);
            }
        }
        for(int i = 0 ; i < battery.length; i++){
            list.add(battery[i][0]);
        }
        Collections.sort(list);

        int cnt = 0;
        ArrayList<Integer> keys = new ArrayList<>();
        for(int unit : list){
            int res = n%unit;
            cnt += (n/unit) * unit;
            keys.add(unit);

            if(cnt >= n){
                break;
            }

        }

        return answer;
    }

}
