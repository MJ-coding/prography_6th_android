package test;

import java.util.HashMap;

public class Kakao1 {

    public static void main(String[] args) {

    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        //조사결과 serveyMap에 저장 RT, CF, JM, AN
        HashMap<Character,Integer> serveyMap = new HashMap<>();
        serveyMap.put('R',0);
        serveyMap.put('T',0);
        serveyMap.put('C',0);
        serveyMap.put('F',0);
        serveyMap.put('J',0);
        serveyMap.put('M',0);
        serveyMap.put('A',0);
        serveyMap.put('N',0);

        //점수 표 scoreMap
        HashMap<Integer,Integer> scoreMap = new HashMap<>();
        scoreMap.put(1,3);
        scoreMap.put(2,2);
        scoreMap.put(3,1);
        scoreMap.put(4,0);
        scoreMap.put(5,1);
        scoreMap.put(6,2);
        scoreMap.put(7,3);

        //choice 3이하이면 charAt(0) 4면 둘다 1+ 5이상이면 charAt(1)
        for(int i = 0 ; i < choices.length; i++){
            int choice = choices[i];
            int score = 0;
            char selected = ' ';
            if(choice <= 3)
            {
                selected = survey[i].charAt(0);
                serveyMap.put(selected, serveyMap.get(selected) + scoreMap.get(choice));

            }
            if(choice >= 5)
            {
                selected = survey[i].charAt(1);
                serveyMap.put(selected, serveyMap.get(selected) + scoreMap.get(choice));

            }
        }
        //RT, CF, JM, AN 순으로 검사 후 같으면 사전순 택
        if(serveyMap.get('R') >= serveyMap.get('T')){
            sb.append("R");
        }else{
            sb.append("T");
        }
        if(serveyMap.get('C') >= serveyMap.get('F')){
            sb.append("C");
        }else{
            sb.append("F");
        }
        if(serveyMap.get('J') >= serveyMap.get('M')){
            sb.append("J");
        }else{
            sb.append("M");
        }
        if(serveyMap.get('A') >= serveyMap.get('N')){
            sb.append("A");
        }else{
            sb.append("N");
        }
        answer = sb.toString();
        return answer;
    }

}
