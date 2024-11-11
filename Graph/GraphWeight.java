import java.util.*;


public class GraphWeight {
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

        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1, 2,10));
        graph[1].add(new Edge(1, 3,0));

        graph[2].add(new Edge(2, 0,2));
        graph[2].add(new Edge(2, 1,10));
        graph[2].add(new Edge(2, 3,-1));

        graph[3].add(new Edge(3, 1,0));
        graph[3].add(new Edge(3, 2,-1));

    }

    public static void findNeighbors(ArrayList<Edge> graph[], int v) {
        for(int i=0; i<graph[v].size(); i++){
            Edge e = graph[v].get(i);
            int neighbor = e.dest;
            System.out.println(neighbor + "," + e.wght);
        }
    }
    public static void main(String args[]) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        findNeighbors(graph, 2);
    }



}
