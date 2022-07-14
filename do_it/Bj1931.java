package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int prevEnd = 0;

        PriorityQueue<Meeting> pq = new PriorityQueue<>(Comparator.comparingInt(Meeting::getEnd)
            .thenComparingInt(Meeting::getStart));//(2,2) (2,1)
        while(N-- >0){
            st = new StringTokenizer(br.readLine());;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Meeting(start,end));
        }

        while(!pq.isEmpty()){
            Meeting current = pq.poll();
            int currentStart = current.getStart();
            int currentEnd = current.getEnd();

            if(currentStart >= prevEnd){
                ans += 1;
                prevEnd = currentEnd;
            }
        }

        System.out.println(ans);
    }

}
class Meeting{
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
