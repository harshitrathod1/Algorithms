package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kruskals {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ver,edg;

        ver = Integer.parseInt(br.readLine());
        edg = Integer.parseInt(br.readLine());

        Graph g = new Graph(ver,true);

        for(int n = 0; n < edg; n++){
            String[] a = br.readLine().split(" ");
            int u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);
            int w = Integer.parseInt(a[2]);

            g.adj.get(u).add(new Edge(u,v,w));
            g.adj.get(v).add(new Edge(v,u,w));
        }

        Edge[] edges = new Edge[edg*2];
        int k = 0;
        for(int i = 0;i < ver;i++){
            for(Edge e : g.adj.get(i)){
                edges[k++] = e;
            }
        }

        //System.out.print(ver);
        Integer sum = kruskalMst(edges,ver);
        if(sum == null) System.out.println("Mst doesn't exists");

        System.out.println(sum);
    }

    static Integer kruskalMst(Edge[] edges,int v){

        UnionFind uf = new UnionFind(v);
//        int[] p = uf.getParent();
//        int[] r = uf.getRank();
//
//        for(int i = 0;i < v;i++){
//            System.out.println(p[i] +" "+r[i]);
//        }

        Arrays.sort(edges);
        int mstSum = 0;

        for(Edge e : edges){

            //skip edge if already connected
            if(uf.connected(e.from,e.to)) continue;

            //union this edge
            uf.union(e.from, e.to);
            System.out.println(e.from+" "+e.to);
            mstSum += e.cost;

            //if(uf.getSize(0) == v) break;
        }

        //System.out.println("Size :"+ uf.getSize(0));
        //if(uf.getSize(0) != v) return null;

        return mstSum;
    }
}
