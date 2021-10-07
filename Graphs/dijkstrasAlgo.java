package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstrasAlgo {
    /* Sample ip and op
ip :-
7
8
0 1 2
0 3 3
1 2 1
3 2 1
1 4 6
4 6 2
4 5 3
6 5 0

op :-
0 2 3 3 8 10 10
    * */

    // Undirected Weighted Graphs
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ver = Integer.parseInt(br.readLine());
        int edg = Integer.parseInt(br.readLine());

        Graph g = new Graph(ver,true);

        for(int n = 0; n < edg; n++){
            String[] a = br.readLine().split(" ");
            int u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);
            int w = Integer.parseInt(a[2]);

            g.adjlist.get(u).add(new Node(v,w));
            g.adjlist.get(v).add(new Node(u,w));
        }

        int src = 0;
         shortestPath(g,src,ver);
    }

    static void shortestPath(Graph g,int src,int v){
        /*
        *  src -> u -> v
        *  dist[u] + cost(u,v) < dist[v]
        *  -> dist[v] = dist[u] + cost(u,v);
        *
        * */
        int[] dis = new int[v];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(1,(n1,n2) -> n1.getWeight() - n2.getWeight());
        pq.offer(new Node(src,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int currentNode = node.getV();

            for(Node adjNode : g.adjlist.get(currentNode)){
                int adjNodeVertex = adjNode.getV();
                if(dis[currentNode] + adjNode.getWeight() < dis[adjNodeVertex]){
                    dis[adjNodeVertex] = dis[currentNode] + adjNode.getWeight();
                    pq.offer(new Node(adjNode.getV(), dis[adjNode.getV()]));
                }
            }
        }

        for(int i = 0;i < v;i++){
            System.out.print(dis[i]+" ");
        }
    }

    void path(Graph g,int src,int n){
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(1, (n1,n2) -> n1.weight - n2.weight);
        pq.offer(new Node(src,0));

        while(!pq.isEmpty()){
            Node c = pq.poll();
            int currentNode = c.v;

            for(Node adjNode : g.adjlist.get(currentNode)){
                if(dist[currentNode] + adjNode.weight < dist[adjNode.v]){
                    dist[adjNode.v] = dist[currentNode] + adjNode.weight;
                    pq.offer(new Node(adjNode.v,dist[adjNode.v]));
                }
            }
        }
    }
}
