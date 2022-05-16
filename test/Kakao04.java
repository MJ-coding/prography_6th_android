package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Queue;

public class Kakao04 {

    public static void main(String[] args) {
        int[] hi = new int[2];
        hi = solution(6,new int[][] {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},
            new int[] {1,3},new int[] {5});
        System.out.println(hi[0] + " " + hi[1]);
    }
    private static int intensity;
    private static ArrayList<Node>[] path;
    private static HashMap<Integer,Integer> gateVisited;
    private static HashMap<Integer,Integer> summitVisited;

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        //[summit,cost]
        int[] answer = new int[2];
        ArrayList<Node> ansList = new ArrayList<>();
        gateVisited = new HashMap<>();
        summitVisited = new HashMap<>();
        path = new ArrayList[paths.length];
        for(int i = 0 ; i < paths.length; i++){
            path[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < paths.length; i++ ){
            int from = paths[i][0];
            int to = paths[i][1];
            int cost = paths[i][2];

            path[from].add(new Node(to,cost));

        }
        for(int i = 0 ; i < gates.length; i++){
            gateVisited.put(gates[i],0);
        }
        for(int i = 0 ; i < summits.length; i++){
            summitVisited.put(summits[i],0);
        }
        //gates,summit 골라서 탐색 시작, 나머지 gates, summit 방문처리
        for(int gate : gates){
            intensity = Integer.MAX_VALUE;

            for(int summit : summits){
                intensity = Math.min(intensity, bfs(gate,summit));
                ansList.add(new Node(summit,intensity));
                summitVisited.put(summit,0);
            }
            gateVisited.put(gate,0);
        }

        Collections.sort(ansList, Comparator.comparingInt(Node::getCost).thenComparingInt(Node::getNode));
        answer[0] = ansList.get(0).getNode();
        answer[1] = ansList.get(0).getCost();

        return answer;
    }
    //방문 노드 중 하나라도 gate or summit이면 비용으로 간주 intesity최소
    //intensity최소 같을 때 summitAnsList.add()
    private static int bfs(int gate , int summit) {
        Queue<Node> q = new ArrayDeque<>();
        int ans = -1;
        gateVisited.put(gate,1);
        summitVisited.put(summit,1);
        q.offer(new Node(gate,0));

        while(!q.isEmpty()){
            Node current = q.poll();

            for(Node next : path[current.getNode()]){

                if(gateVisited.containsKey(next.getNode()) && gateVisited.get(next.getNode()) == 0){
                    continue;
                }

                if(summitVisited.containsKey(next.getNode()) && summitVisited.get(next.getNode()) == 0){
                    continue;
                }

                if((!gateVisited.containsKey(current.getNode()) && !summitVisited.containsKey(current.getNode()) ) &&
                    (!gateVisited.containsKey(next.getNode()) && !summitVisited.containsKey(next.getNode())))
                {
                    continue;
                }

                if(next.getNode() == gate){
                    return next.getCost();
                }
                q.offer(next);
                ans = next.getCost();

            }
        }
        System.out.println("hhh");
        return ans;
    }

}
class Node{
    private int node;
    private int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getNode(){
        return this.node;
    }
}
