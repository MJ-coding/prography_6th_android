package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Pro42626 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        //사용한 스코빌 check
        int size = scoville.length;
        Info minInfo;
        Info nextMinInfo;
        int[] check = new int[size];
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(Info::getScove));

        for(int i = 0 ; i < size ;i++){
            pq.add(new Info(scoville[i],i));
        }
        int going = 1;
        for(int i = 0 ; i<size ; i++){
            if(check[i] != -1)
                break;
            going = 0;
        }
        while( !isUpperThenK(pq, K) && going ==1){
            minInfo = pq.poll();
            nextMinInfo = pq.poll();

            if(minInfo.getIndex() != -1 )
                check[minInfo.getIndex()] = 1;
            if(nextMinInfo.getIndex() != -1)
                check[nextMinInfo.getIndex()] = 1;
            pq.add(new Info(mixScovile(minInfo.getScove(), nextMinInfo.getScove()),-1));
            answer++;
        }

        for(int i = 0 ; i<size ; i++){
            if(check[i] != -1)
                return answer;
        }

        return -1;
    }
    public static int mixScovile(int min , int nextMin){
        return min + nextMin*2;
    }
    public  static boolean isUpperThenK(PriorityQueue<Info> pq , int k){
        for(Info info : pq){
            if(info.getScove() < k){
                return false;
            }
        }
        return true;
    }

}
class Info{
    int scove;
    int index;

    public Info(int scove, int index) {
        this.scove = scove;
        this.index = index;
    }

    public int getScove() {
        return scove;
    }

    public void setScove(int scove) {
        this.scove = scove;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
