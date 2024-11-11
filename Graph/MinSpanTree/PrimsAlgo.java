// package MinSpanTree;
// package Graph.MinSpanTree;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
         static class Edge {
                int src; // source i.e vertex of index 
                int dest; // destination i.e vertex 
                int wght; // weight of the edge 

                public Edge (int s, int d , int w) {
                    this.src = s;
                    this.dest = d;
                    this.wght = w;
                }
            }
            

            public static void createGraph(ArrayList<Edge> graph[]) {
                for(int i=0;i<graph.length; i++) {
                    graph[i] = new ArrayList<Edge>();
                }

                graph[0].add(new Edge(0,1,10));
                graph[0].add(new Edge(0,2,15));
                graph[0].add(new Edge(0,3,30));

                graph[1].add(new Edge(1,3,40));
                graph[1].add(new Edge(1,0,10));

                graph[2].add(new Edge(2, 3,50));
                graph[2].add(new Edge(2, 0,15));

                graph[3].add(new Edge(3, 0,30));
                graph[3].add(new Edge(3, 1,40));
                graph[3].add(new Edge(3, 2,50));
            

            }

            public static class Pair implements Comparable<Pair> {
                int node;
                int cost;
    
                public Pair(int n, int w) {
                    this.node = n;
                    this.cost = w;

                }

                @Override
                public int compareTo(Pair o) {
                    return this.cost - o.cost; // ascending order
                }
            }
           
            public static int findMSTcost(ArrayList<Edge> graph[], ArrayList<Edge> mst , int V){
                PriorityQueue<Pair> pq = new PriorityQueue<>();
                boolean vis[] = new boolean[V];
                int cost = 0;
                pq.add(new Pair(0,0));
                while(!pq.isEmpty()) {
                    Pair curr = pq.poll();
                    if(!vis[curr.node]){
                        vis[curr.node] = true;
                        cost += curr.cost;

                       for(Edge e : graph[curr.node]) {
                        if(e.wght == curr.cost && vis[e.dest]){
                            mst.add(new Edge(e.dest, e.src, e.wght));
                        }
                       }
                        for(int i=0; i<graph[curr.node].size();i++) {
                            Edge e = graph[curr.node].get(i);
                            if(!vis[e.dest]){
                                pq.add(new Pair(e.dest,e.wght));
                            }
                        }
                    }
                }

                return cost;
            }
       
        
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        ArrayList<Edge> mst = new ArrayList<>();
         int cost = findMSTcost(graph, mst,V);
         

        System.out.println("Minimum Spanning Tree: ");

        for(Edge e : mst){
            System.out.println(e.src+" -> "+e.dest+" : "+e.wght);
        }

       

    }
}
