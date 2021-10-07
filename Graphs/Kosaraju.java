package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Kosaraju {

    public static void main(String[] args) throws IOException {
        ArrayList<HashSet<Integer>> adjList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        for(int i = 0;i < v;i++){
            adjList.add(new HashSet<>());
        }

        for(int i = 0;i < e;i++){
            String[] a = br.readLine().split(" ");
            int from = Integer.parseInt(a[0]);
            int to = Integer.parseInt(a[1]);

            adjList.get(from).add(to);
        }

        //step1 : random order dfs
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] vis = new boolean[v];
        for(int i = 0;i < v;i++){
            if(vis[i] == false){
                dfs1(adjList,stack,vis,0);
            }
        }
        //step2 : reverse all edges
        ArrayList<HashSet<Integer>> adjList2 = new ArrayList<>();
        for(int i = 0;i < v;i++){
            adjList2.add(new HashSet<>());
        }
        for(int from = 0;from < v;from++){
            for(Integer to : adjList.get(from)){
                adjList2.get(to).add(from);
            }
        }

        //step3: do dfs in stack order in new graph
        vis = new boolean[v];
        int scc =  0;

        ArrayList<ArrayList<Integer>> comp = new ArrayList<>();

        while (!stack.isEmpty()){
            int u = stack.pop();
            if(vis[u] == false){
                ArrayList<Integer> subcomp = new ArrayList<>();
                dfs2(adjList2,u,vis,subcomp);
                scc++;
                comp.add(subcomp);
            }
        }

        System.out.println(scc);
        System.out.println(comp);

    }

    static void dfs1(ArrayList<HashSet<Integer>> adjList,Stack<Integer> stack,boolean[] vis,int src){

        vis[src] = true;

        for(Integer v : adjList.get(src)){
            if(vis[v] == false){
                dfs1(adjList,stack,vis,v);
            }
        }

        stack.add(src);
    }

    static void dfs2(ArrayList<HashSet<Integer>> adjList,int src,boolean[] vis,ArrayList<Integer> subcomp){

        vis[src] = true;
        subcomp.add(src);
        for(Integer u : adjList.get(src)){
            if(vis[u] == false){
                dfs2(adjList,u,vis,subcomp);
            }
        }
    }
}
