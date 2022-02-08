package disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10216 {

    private static final String NEW_LINE = "\n";
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            Circle[] circles = new Circle[N];
            parent = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                circles[i] = new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
                parent[i] = -1;

            }

            mergeCircles(circles);
            for(int i = 0; i< parent.length; i++){
                if(parent[i]>=0) continue;
                cnt++;
            }
            sb.append(cnt).append(NEW_LINE);
        }

        System.out.println(sb);
    }
    private static void mergeCircles(Circle[] circles){
        for(int i = 0; i < circles.length-1; i++){
            for(int j = i+1; j < circles.length; j++){
                if(!euclideanCircle(circles[i],circles[j])) continue;
                merge(i,j);
            }
        }
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(parent[x] < parent[y]){
            parent[x] += parent[y];
            parent[y] = x;
        }else{
            parent[y] += parent[x];
            parent[x] = y;
        }

    }

    private static boolean euclideanCircle(Circle c1, Circle c2){
        int xDiff = c1.getX() - c2.getX();
        int yDiff = c1.getY() - c2.getY();
        int circleDiff = xDiff*xDiff + yDiff*yDiff;

        return (c1.getR()+c2.getR())*(c1.getR()+c2.getR()) >= circleDiff ? true : false;

    }
    private static int find(int x){
        if(parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }
}

class Circle{
    private int x;
    private int y;
    private int r;

    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getR(){
        return r;
    }
}
