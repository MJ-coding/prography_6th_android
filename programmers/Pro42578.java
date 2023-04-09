package programmers;

import java.util.HashMap;

public class Pro42578 {

    public static void main(String[] args) {
        System.out.println(solution(new String[][] {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        }));
    }

    public static int answer = 1;
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        //int answer = 1;

        for(String[] clothe : clothes){
            //같은종류의 의상수 구하기
            map.merge(clothe[1],1, Integer::sum);
        }
        //의상을 선택하거나 안할경우 x+1
        map.values().forEach( x -> answer *= (x+1)) ;
        //answer - 모든 의상을 선택하지않을경우
        return answer -1;
    }

}
