package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bipartite {
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
            g.adjList.get(v).add(u);
        }

        int[] color = new int[ver];
        Arrays.fill(color,-1);
        //0-blue 1-green

        boolean ans = checkBipartite(ver,color,g);
        System.out.println(ans);
    }

    static boolean checkBipartite(int ver,int[] color,Graph g){
        for(int i = 0; i < ver;i++){
            if(color[i] == -1){
                boolean val = dfsHelper(g,color,1,i);
                if(val == false) return false;
            }
        }
        return true;
    }

    static boolean dfsHelper(Graph g,int[] color,int currentColor,int cNode){

        color[cNode] = currentColor;

        for(Integer adjNode : g.adjList.get(cNode)){
            if(color[adjNode] == -1){
                boolean a  = dfsHelper(g,color,1-currentColor,adjNode);
                if(a == false) return false;
            }
            else if(color[adjNode] == currentColor){
                return false;
            }
        }

        return true;
    }
}
