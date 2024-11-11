import java.util.*;

public class DijkstraAlgo {

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

                graph[0].add(new Edge(0,2,4));
                graph[0].add(new Edge(0,1,2));

                graph[1].add(new Edge(1,3,7));
                graph[1].add(new Edge(1, 2,4));

                graph[2].add(new Edge(2, 4,3));

                graph[3].add(new Edge(3, 5,1));

                graph[4].add(new Edge(4, 5,5));
                graph[4].add(new Edge(4, 3,2));

            }

            public static class Pair implements Comparable<Pair> {
                int node;
                int dist;
    
                public Pair(int n, int d) {
                    this.node = n;
                    this.dist = d;
                }

                @Override
                public int compareTo(Pair o) {
                    return this.dist - o.dist; // ascending order
                }
            }

        public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int dist[] = new int[V];
            for(int i=0;i<V;i++) {
                if(i != src) {
                    dist[i] = Integer.MAX_VALUE; // setting all the distances to infinity
                }
            }
            boolean vis[] = new boolean[V];

            pq.add(new Pair(0,0));

            while(!pq.isEmpty()){
                Pair curr = pq.remove(); // 
                if(!vis[curr.node]) {
                    vis[curr.node] = true;
                    for(int i=0; i<graph[curr.node].size(); i++) {
                        Edge e = graph[curr.node].get(i);
                        int u = e.src;
                        int v = e.dest;
                        if(dist[u] + e.wght < dist[v]){
                            dist[v] = dist[u] + e.wght;
                            pq.add(new Pair(v, dist[v]));
                        }
                    }
                }
                
            }

             for(int i=0;i<V;i++) {
                System.out.println("Distance of " + i + " from source is " + dist[i]);
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];
        for (int i=0;i<V; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
    }
        
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);
    }
        

}