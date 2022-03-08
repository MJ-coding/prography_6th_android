package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj2910 {
    private static StringBuilder sb;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        PriorityQueue<SequenceInfo> pq = new PriorityQueue<>(Comparator
                .comparingInt(SequenceInfo::getFrequency)
                .thenComparingInt(SequenceInfo::getIndex));

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!frequencyMap.containsKey(num)){
                indexMap.put(num,i);
            }
            frequencyMap.merge(num,1,Integer::sum);
        }

        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            int key = entry.getKey();
            int frequency= entry.getValue();

            pq.offer(new SequenceInfo(key,frequency,indexMap.get(key)));
        }

        while(!pq.isEmpty()){
            SequenceInfo current = pq.poll();
            for(int i = 0 ; i < -current.getFrequency(); i++){
                sb.append(current.getSequenceNumber()).append(" ");
            }
        }

        System.out.println(sb);

    }
}

class SequenceInfo {
    private int sequenceNumber;
    private int frequency;
    private int index;

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public int getFrequency() {
        return -frequency;
    }

    public int getIndex() {
        return index;
    }

    public SequenceInfo(int sequenceNumber, int frequency, int index) {
        this.sequenceNumber = sequenceNumber;
        this.frequency = frequency;
        this.index = index;
    }
}