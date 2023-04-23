package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro42746 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}) );
    }

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int size = numbers.length;
        List<String> strNumber = new ArrayList<>();
//1의자리 정렬 2의자리정렬
        for(int i = 0 ; i < size ; i++){
            if(numbers[i] < 10){
                strNumber.add(numbers[i] + "9");
            }else{
                strNumber.add(String.valueOf(numbers[i]));
            }
        }
        Collections.reverse(strNumber);

        for(String str : strNumber){
            sb.append(str);
        }
        return sb.toString();
    }

}
