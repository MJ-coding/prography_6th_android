package line_sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Conference> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.getTime()));
        StringTokenizer st;

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Conference(Integer.parseInt(st.nextToken()),1));
            pq.offer(new Conference(Integer.parseInt(st.nextToken()),-1));
        }
        System.out.println(countMinimumConference(pq));
    }
    //private static Comparator<Conference> compare = (o1, o2) -> o1.getTime() < o2.getTime() ? -1 : 1;

    private static int countMinimumConference(PriorityQueue<Conference> pq){
        int maxConferenceNum = Integer.MIN_VALUE;
        int sum = 0;

        while(!pq.isEmpty()){
            Conference conference = pq.poll();
            sum += conference.getType();
            maxConferenceNum = Math.max(sum,maxConferenceNum);
        }
        return maxConferenceNum;
    }
}
class Conference{
    private int time;
    private int type;//end(-1) or start(1)

    public Conference(int time, int type){
        this.time = time;
        this.type = type;
    }

    public int getTime(){
        return time;
    }
    public int getType(){
        return type;
    }
}
