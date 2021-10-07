package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class LazyPrimsAlgorithm {

    //Graph input
    private static Graph g;
    private static int ver; // totalNoOfVertices
    private static int edg; // totalNoOfEdges

    //Prims Setup
    private static PriorityQueue<Edge> pq;
    private static boolean[] visited;

    //output
    private static boolean mstExists;
    private static Edge[] mstEdges;
    private static int minCostSum;

    static void solve(){
        // setup
        int m = ver - 1,edgeCount = 0;
        pq = new PriorityQueue<>(ver,(a,b) -> a.cost - b.cost);
        visited = new boolean[ver];
        mstEdges = new Edge[m];

        addEdgesToPq(0);

        while(!pq.isEmpty() && edgeCount != m){
            Edge edge = pq.poll();
            int nodeIndex = edge.to;

            if(visited[nodeIndex] == true) continue;

            minCostSum += edge.cost;
            mstEdges[edgeCount++] = edge;

            addEdgesToPq(nodeIndex);
        }

        mstExists = (edgeCount == m);
    }

    static void addEdgesToPq(int nodeIndex){
        visited[nodeIndex] = true;

        for(Edge adjNode : g.adj.get(nodeIndex)){
            if(!visited[adjNode.to]){
                pq.offer(adjNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ver = Integer.parseInt(br.readLine());
        edg = Integer.parseInt(br.readLine());

        g = new Graph(ver,true);

        for(int n = 0; n < edg; n++){
            String[] a = br.readLine().split(" ");
            int u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);
            int w = Integer.parseInt(a[2]);

            g.adj.get(u).add(new Edge(u,v,w));
            g.adj.get(v).add(new Edge(v,u,w));
        }

        solve();

        System.out.println(minCostSum);

        for(int i = 0; i < ver - 1;i++){
            System.out.println(mstEdges[i].from +" "+mstEdges[i].to);
        }
    }

    // 5 6
}
