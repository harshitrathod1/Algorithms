package Graphs;

public class Edge implements Comparable<Edge> {

    int to,from,cost;

    public Edge(int from,int to,int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
