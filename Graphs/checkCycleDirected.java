package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class checkCycleDirected {
    private static int WHITE = 0;
    private static int BLACK = 1;
    private static int GRAY = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ver = Integer.parseInt(br.readLine());
        int edg = Integer.parseInt(br.readLine());

        Graph g = new Graph(ver);

        for(int n = 0; n < edg; n++){
            String[] a = br.readLine().split(" ");
            int u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);

            g.adjList.get(u).add(v);
        }

        int[] color = new int[ver];
        Arrays.fill(color,WHITE);

        for(int i = 0;i < ver;i++){
            if(color[i] == WHITE){
                boolean ans = dfs(g,color,i);
                // for single connected component
                // this will run only once hence printing in the loop.
                System.out.print(ans);
            }
        }
    }
    static int cycle_start;
    static int cycle_end;

    static boolean dfs(Graph g,int[] color,int ver){
        color[ver] = GRAY;

        for(Integer adjNode : g.adjList.get(ver)){
            if(color[adjNode] == WHITE){
                boolean a = dfs(g,color,adjNode);
                if(a == true) return true;
            }else if(color[adjNode] == GRAY){
                cycle_start = adjNode;
                cycle_end = ver;
                return true;
            }
        }
        color[ver] = BLACK;
        return false;
    }
}
