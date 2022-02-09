class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1step
        answer = new_id.toLowerCase();
        //2step
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        //3step
        answer = answer.replaceAll("[.]{2,}+",".");
        //4step
        answer = answer.replaceAll("^[.]|[.]$","");
        //5step
        if(answer.equals(""))
            answer += "a";
        //6step
        if(answer.length()>15){
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$","");
        }
        //7step
        if(answer.length()<3){
            while(answer.length() !=3){
                answer += answer.charAt(answer.length()-1);
            }

        }
        return answer;
    }
}