package implementation;
//자물쇠와 열쇠 2020카카오 공채
public class Pro60059 {

    public static void main(String[] args) {

    }
}
class Solution {
    void match(int[][] arr, int[][]key, int rot,int r, int c){
        int n = key.length;
        for(int i =0;i<n; ++i){
            for(int j=0; j<n ; ++j){
                //System.out.println("i:"+i);
                if(rot ==0){
                    arr[r+i][c+j] +=key[i][j];
                }else if(rot == 1){
                    //열을 행으로 transfer
                    arr[r+i][c+j] += key[j][n-1-i];
                }else if(rot ==2){
                    arr[r+i][c+j] += key[n-1-i][n-1-j];
                }else{
                    arr[r+i][c+j] += key[n-1-j][i];
                }

            }
        }
    }
    boolean check(int[][] arr,int offset,int n){
        for(int i=0; i<n; ++i){
            for(int j =0; j<n ; ++j){
                if(arr[offset+i][offset+j] != 1){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean solution(int[][] key, int[][] lock) {
        //key와 lock이 겹치는 마지막 위치
        int offset = key.length -1;
        //크게 회전할 위치
        for(int r =0; r< offset + lock.length; ++r){
            for(int c=0; c< offset + lock.length; ++c){
                //회전
                for(int rot =0; rot<4 ; ++rot){
                    //최대 20: 20+20+20 -2겹치는부분
                    int[][] arr = new int[58][58];
                    for(int i = 0; i<lock.length;++i){
                        for(int j = 0; j<lock.length; ++j){
                            arr[offset+i][offset+j] = lock[i][j];

                        }
                    }

                    //key더하기
                    match(arr,key,rot,r,c);
                    if(check(arr,offset,lock.length)){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}