import java.util.*;
@SuppressWarnings("unchecked")
public class DirectedGraph {
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

        // example of cycle detection
        // graph[0].add(new Edge(0,2));
        // graph[1].add(new Edge(1,0));
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));
        

        // example of topological sort
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 1));
        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));
        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));
        

        //example for undirected cycle detection using dfs 
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        // graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
        // graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

    }

    public static boolean isCyclic(ArrayList<Edge> graph[], int curr, boolean visited[], boolean recStack[]) {
        visited[curr] = true;
        recStack[curr] = true;

        for(int i=0; i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(recStack[e.dest]) {
                return true;
            }

            else if (!visited[e.dest]){
                 if (isCyclic(graph, e.dest, visited, recStack))
                 return true;
            }
        }
        
        recStack[curr] = false;
        return false;
      
    }


    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[], int V) {
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<V;i++) {  //as this is directed graph there will be nodes without neighbours .
            if(!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean undirectedCycle(ArrayList<Edge> graph[], int curr,int parent, boolean visited[]) {
        visited[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(visited[e.dest] && parent!= e.dest) {
                    return true;
                
            }
            else if(!visited[e.dest]) {
                if(undirectedCycle(graph, e.dest, curr, visited)) {
                    return true;
                }
            }
        }

        return false;
     
      
    }
    public static void main(String[] args) {
        // int V=4; cyclic 
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean visited[] = new boolean[V]; 
        boolean recStack[] = new boolean[V];

        //undirected graph cycle detection using dfs 
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                boolean iscycle = undirectedCycle(graph, i,-1, visited);
                if(iscycle) {
                    System.out.println(iscycle);
                    break;
                }
                System.out.println(iscycle);
            }
        }
        

        // topSort(graph, V); // topological sort

        // for(int i=0;i<V;i++) { // to make sure all the vertices are visited , if there are any disconnected nodes
        //     if(!visited[i]){
        //         boolean iscycle =  isCyclic(graph, 0, new boolean[V], new boolean[V]);

        //         if(iscycle){ // to get out of the loop as soon as we find a cycle 
        //             System.out.println(iscycle);
        //             break;
        //         }

        //     }
        // }
        

    }
    
}
