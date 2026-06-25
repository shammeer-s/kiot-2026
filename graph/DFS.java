import java.util.*;

class Graph {
    List<List<Integer>> adj;
    int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>(this.vertices);
        for(int i=0; i<vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void print() {
        System.out.println("\nAdjacency List");
        for(int i=0; i<vertices; i++) {
            System.out.print(i+": ");
            System.out.println(adj.get(i));
        }
    }

    public void bfs(int u) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("BFS: ");
        visited[u] = true;
        queue.add(u);

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex+ " ");

            for(int adjVertex : adj.get(vertex)) {
                if (!visited[adjVertex]) {
                    queue.add(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }
        System.out.println();
    }

    public void dfs(int u) {
        System.out.print("DFS : ");
        boolean[] visited = new boolean[this.vertices];
        dfsRecursive(u, visited);
    }

    public void dfsRecursive(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u+" ");
        for(int av : adj.get(u)) {
            if (!visited[av]) {
                dfsRecursive(av, visited);
            }
        }
        System.out.println();
    }
}

public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 4);
        graph.addEdge(3, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.print();
        System.out.println();
        graph.bfs(0);
        System.out.println();
        graph.dfs(0);

    }
}
