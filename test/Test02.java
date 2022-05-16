package test;

public class Test02 {

    public static void main(String[] args) {
        solution(new String[] {"……….","AAACC…..",".AAA…..Z","..AAAA..C.","…BBBBB..",
            "….BBB…","…ZBBB…","ZZZZAAAC..","…..CCCC.","QQ……C.","………."});
    }
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int[][] boundary;

    public static int[] solution(String[] maps) {
        int[] answer = new int[2];
        int n = maps.length;
        int m = maps[0].length();
        int maxNum = Integer.MIN_VALUE;
        int pairNum = 0;

        boundary = new int[26][26];//국경 공유시 1

        boundary = getBoundaryInfo(maps,boundary,n,m);


        for(int i = 0 ; i < 26; i++){
            int num = 0;
            for(int j = i+1; j < 26; j++){
                if(boundary[i][j] == 1) {
                    num++;
                    pairNum++;
                }
            }
            maxNum = Math.max(maxNum,num);

        }

        answer[0] = pairNum;
        answer[1] = maxNum;

        return answer;
    }

    private static int[][] getBoundaryInfo(String[] maps, int[][] boundary, int n, int m) {
        char currentCountry;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(maps[i].charAt(j) != '.'){
                    currentCountry = maps[i].charAt(j);
                    for(int[] DIRECTION : DIRECTIONS) {
                        int nextX = i + DIRECTION[0];
                        int nextY = j + DIRECTION[1];
                        if( nextX < 0 || nextX >= n || nextY < 0 || nextY >= m ) continue;
                        if(maps[nextX].charAt(nextY) != '.'){
                            char nearCountry = maps[nextX].charAt(nextY);
                            boundary[currentCountry-65][nearCountry-65] = 1;
                            boundary[nearCountry-65][currentCountry-65] = 1;
                        }
                    }
                }
            }
        }
        return boundary;
    }


}
