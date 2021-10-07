package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    /*
        1. Shortest path algorithm.
        2. Handles negative edge weights.
        3. Not capable to handling negative cycles.
    */

    static class Edge{
        int from;
        int to;
        int cost;
        Edge(int f,int t,int c){
            this.from = f;
            this.to = t;
            this.cost = c;
        }

    }

    public static void main(String[] args) throws IOException {

        ArrayList<Edge> adjList = new ArrayList<>();
        int v = 5;

        adjList.add(new Edge(0,1,-1));
        adjList.add(new Edge(1,2,2));
        adjList.add(new Edge(2,3,-3));
        adjList.add(new Edge(3,4,5));

        adjList.add(new Edge(0,4,4));
        adjList.add(new Edge(1,4,3));
        adjList.add(new Edge(1,3,2));
        adjList.add(new Edge(3,1,1));


        bellman(adjList,v,0);
    }

    static void bellman(ArrayList<Edge> adjList,int v,int start){
        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[start] = 0;

        for(int i = 0;i < v-1;i++){
            for(Edge e: adjList){
                if(dist[e.from] + e.cost < dist[e.to]){
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        int flag = 0;
        for(Edge e : adjList){
            if(dist[e.from] + e.cost < dist[e.to]){
                flag = 1;
                System.out.println("Negative cycle");
                break;
            }
        }

        if(flag ==0){
            for(int i = 0;i < v;i++){
                System.out.print(dist[i]+" ");
            }
        }
    }



}
