package do_it;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Bj11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        ArrayDeque<Node> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++)
        {

            int now = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.getLast().value > now){
                dq.removeLast();
            }
            dq.addLast(new Node(i,now));

            if(dq.getFirst().index <= i-L){
                dq.removeFirst();
            }
            bw.append(dq.getFirst().value + " ");
        }

        bw.flush();
        bw.close();

    }

}
class Node{
    public int index;
    public int value;

    Node(int index, int value){
        this.index = index;
        this.value = value;
    }
}
