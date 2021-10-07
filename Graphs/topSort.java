package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class topSort {

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

        //Topological ordering is only applicable for DAG
        boolean[] vis = new boolean[ver];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0;i < ver;i++){
            if(vis[i] == false){
                dfs(g,i,vis,stk);
            }
        }
        Collections.reverse(stk);
        System.out.println(stk);

    }

    static void dfs(Graph g,int cNode,boolean[] vis,Stack<Integer> stack){
        vis[cNode] = true;

        for(Integer adjNode : g.adjList.get(cNode)){
            if(vis[adjNode] == false){
                dfs(g,adjNode,vis,stack);
            }
        }

        stack.push(cNode);
        return;
    }
}
