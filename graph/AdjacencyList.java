import java.util.ArrayList;
import java.util.List;

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
}

public class AdjacencyList {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.print();
    }
}
