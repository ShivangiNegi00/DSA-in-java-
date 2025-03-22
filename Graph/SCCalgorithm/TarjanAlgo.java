
//we will be using tarjan algorithm to find bridges in the graph

import java.util.ArrayList;

public class TarjanAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));

    }

    public static void dfs(ArrayList<Edge> graph[], int src, int dt[], int low[],boolean vis[], int time, int parent){
        vis[src]= true;
        dt[src] = low[src]= ++time; 

        for(int i=0 ; i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest]) {
                dfs(graph,e.dest,dt,low,vis,time,src);
                low[src] = Math.min(low[src],low[e.dest]);
                if(dt[src] < low[e.dest]){
                    System.out.println(src + "---" + e.dest);
                }
            }

            else if(e.dest != parent){
                low[src] = Math.min(low[src],dt[e.dest]);
            }
        }
    }


    public  static void findBridge(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V]; //discovery time
        int low[] = new int[V]; //Low time
        int time = 0;
        boolean vis[] = new boolean[V]; 
        for(int i=0;i<V;i++){ // if there are disconnected components of the graph then nodewise call dfs 
            if(!vis[i]){
                dfs(graph,i,dt,low,vis,time,-1);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        findBridge(graph,V);
    }

}