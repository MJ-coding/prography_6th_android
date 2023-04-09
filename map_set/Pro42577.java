package map_set;

import java.util.Arrays;

public class Pro42577 {

    public static void main(String[] args) {

        System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
        //System.out.println(solution(new String[] {"912", "97674223", "1195524421" , "111233334422222999"}));

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        //정렬하여 접두어에 같은부분 나오는지 확인
        //정렬하면 양옆으로 접두어에 같은부분이 포함된 전화번호가 있을것이다.
        Arrays.sort(phone_book);
        int currentLength = 0;
        int nextLength = 0;
        //1. 전화번호길이가 같으면 같은번호인지 확인
        //2. 길이가 다르면 짧은 길이 기준으로 접두어 같은지 확인
        for (int i = 0 ; i < phone_book.length - 1 ; i++){
            String current = phone_book[i];
            String next = phone_book[i+1];
            currentLength = current.length();
            nextLength = next.length();

            if(currentLength == nextLength){
                if(current.equals(next)){
                    answer = false;
                    return answer;
                }else{
                    continue;
                }
            }else if(currentLength < nextLength){
                String prePhoneNum = next.substring(0,currentLength);
                if(prePhoneNum.equals(current)){
                    answer = false;
                    return answer;
                }
            }else{
                String prePhoneNum = current.substring(0,nextLength);
                if(prePhoneNum.equals(next)){
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }

}
