// package Graph.SCCalgorithm;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
    static class Edge {
        int src,dest;

        public Edge(int s , int d ) {
          this.src = s;
          this.dest = d;
        }

  }

  public static void createGraph(ArrayList<Edge> graph[]) {
      for(int i=0;i<graph.length;i++) {
          graph[i] = new ArrayList<Edge>();
      }

      graph[0].add(new Edge(0,2));
      graph[0].add(new Edge(0,3));

      graph[1].add(new Edge(1,0));

      graph[2].add(new Edge(2,1));

      graph[3].add(new Edge(3,4));


  }

  public static void topSort(ArrayList<Edge> graph[], int src, boolean vis[], Stack<Integer> s){
    vis[src] = true;
    for(int i = 0; i<graph[src].size(); i++){
      Edge e = graph[src].get(i);
      if(!vis[e.dest]){
        topSort(graph, e.dest, vis, s);
      }
    }
    s.push(src);
  }

  public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
    vis[curr] = true;
    System.out.print(curr + " ");
    for(Edge e : graph[curr]) {
      if(!vis[e.dest]){
        dfs(graph,e.dest,vis);
      }
    }
  }

  public static void KosarajuAlgo(ArrayList<Edge> graph[], int V){
    //step 1 : topological sort
    Stack<Integer> s = new Stack<>();
    boolean vis[] = new boolean[V];
    for(int i=0;i<V;i++){
      if(!vis[i]){
        topSort(graph, i, vis, s);
      }
    }

    //step 2 : reverse the graph
    ArrayList<Edge> revGraph[] = new ArrayList[V];
    for(int i=0;i<graph.length;i++){
        vis[i] = false;
      revGraph[i] = new ArrayList<Edge>();
    }

    for(int i=0;i<V;i++){
      for(Edge e : graph[i]) {
        revGraph[e.dest].add(new Edge(e.dest, e.src));
      }
    }
  
    //step 3 : DFS on reversed graph
    // vis = new boolean[V];
    while(!s.isEmpty()){
      int curr= s.pop();
      if(!vis[curr]){
        dfs(revGraph,curr,vis);
        System.out.println();
      }
    }

    
  }

  public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        KosarajuAlgo(graph,V);
  }
    
}
