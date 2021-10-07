package Graphs;

import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> adjList;
    ArrayList<ArrayList<Node>> adjlist;
    ArrayList<ArrayList<Edge>> adj;

    int vertices;
    private boolean weighted = false;

    Graph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();
        allocateSpace();
    }

    Graph(int _vertices,boolean _weighted){
        weighted = _weighted;
        vertices = _vertices;
        adj = new ArrayList<>();
        //adjlist = new ArrayList<>();
        //allocate();
        allocateWeightedSpace();
    }

    private void allocate(){
        for (int i = 0; i < vertices;i++){
            adjlist.add(new ArrayList<>());
        }
    }
    private void allocateSpace(){
        for(int i = 0; i < vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    private void allocateWeightedSpace(){
        for(int i = 0;i < vertices;i++){
            adj.add(new ArrayList<>());
        }
    }
}
