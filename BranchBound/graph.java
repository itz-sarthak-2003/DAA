
import java.util.*;

// This class represents a directed graph using an adjacency list
class graph {

    // Number of vertices
    private int V;

    // Array of lists for storing connected nodes (adjacency list)
    private LinkedList<Integer> adj[];

    // Constructor to create a graph with V vertices
    @SuppressWarnings("unchecked")
    graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Method to add a directed edge from vertex 'v' to vertex 'w'
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A helper method that uses recursion to count all paths from 'u' to 'd'
    int countPathsUtil(int u, int d, int pathCount) {
        // If the current vertex 'u' is the destination 'd', increment the path count
        if (u == d) {
            pathCount++;
        } else {
            // Otherwise, explore all adjacent vertices of 'u'
            for (int neighbor : adj[u]) {
                pathCount = countPathsUtil(neighbor, d, pathCount);
            }
        }
        return pathCount;
    }

    // Method to count all paths from source 's' to destination 'd'
    int countPaths(int s, int d) {
        return countPathsUtil(s, d, 0);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create a graph with 5 vertices (0 to 4)
        graph g = new graph(5);

        // Add directed edges between vertices
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        // Set the source (s) and destination (d)
        int s = 0, d = 3;

        // Count and print the number of paths from s to d
        System.out.println(g.countPaths(s, d)); // Output will be the number of paths from vertex 0 to 3
    }
}
