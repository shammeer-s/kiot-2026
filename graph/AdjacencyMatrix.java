class Graph {
    int[][] matrix;
    int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        this.matrix[u][v] = 1;
        this.matrix[v][u] = 1;
    }

    public void print() {
        System.out.println("\nAdjacency Matrix");
        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class AdjacencyMatrix {
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
