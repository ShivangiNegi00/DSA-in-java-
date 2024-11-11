import java.util.*;

public class GraphUnWeight {
    static class Edge {
        int src;
        int dest;

        public Edge (int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // example of graph using adjacency list 
        // graph[0].add(new Edge(0,2));

        // graph[1].add(new Edge(1, 2));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));
        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 2));

        
        // BFS example 
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
        
    }

    public static void findNeighbors(ArrayList<Edge> graph[], int v) {
        for(int i=0; i<graph[v].size(); i++){
            Edge e = graph[v].get(i);
            int neighbor = e.dest;
            System.out.println("Neighbor of " + v + " is " + neighbor);
        }
    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start) {
        Queue<Integer> q = new LinkedList<>();
    
        q.add(start);

        while(!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false) {
                System.out.println(curr);
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                    
                }         
               }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;
        
        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false) {
                dfs(graph,e.dest, vis);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[] , int curr, int tar, String path){
        if(curr == tar) {
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                vis[curr] = true ;
                printAllPath(graph, vis, e.dest, tar, path + e.dest);
                vis[curr] = false;
            }
        }

    }
    public static void main(String args[]) {
        // for just graph implementation example 
        // int v = 4;
        // ArrayList<Edge> graph[] = new ArrayList[v];
        // createGraph(graph);
        // findNeighbors(graph, 2); 

        //BFS traversal
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        // for(int i=0; i<V; i++) {
        //     if(vis[i] == false) {
        //         bfs(graph,V,vis,i);
        //     }
        // }
        // System.out.println();

        // DFS exmaple
        // for(int i=0; i<V; i++) {
        //     if(vis[i] == false) {
        //         dfs(graph,i,vis);
        //     }
        // }

        int src = 0 , tar = 5;
        printAllPath(graph, new boolean[V], src, tar, "0");
        System.out.println();

    }
}





