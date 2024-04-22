import java.util.ArrayList; 
class Graph {
int[][] adjacencyMatrix; int vertices;
Graph(int[][] adjacencyMatrix) {
this.adjacencyMatrix = adjacencyMatrix; this.vertices = adjacencyMatrix.length;
}
boolean DLS(int src, int target, int depth, ArrayList<Integer> path) { path.add(src);
if (src == target) { return true;
}
if (depth <= 0) {
path.remove(path.size() - 1); return false;
}
for (int i = 0; i < vertices; i++) {
if (adjacencyMatrix[src][i] != 0) {
 
if (DLS(i, target, depth - 1, path)) { return true;
}
}
}

path.remove(path.size() - 1); return false;
}

boolean shortestPathIDDFS(int src, int target, int maxDepth, ArrayList<Integer> path) {
for (int i = 0; i <= maxDepth; i++) { path.clear();
if (DLS(src, target, i, path)) { return true;
}
}

return false;
}}

public class IDS {
public static void main(String[] args) { int[][] adjacencyMatrix = {
{0, 2, 3, 0, 0, 0, 0},
{2, 0, 0, 4, 0, 0, 0},
{3, 0, 0, 0, 5, 0, 0},
{0, 4, 0, 0, 0, 6, 0},
{0, 0, 5, 0, 0, 0, 7},
{0, 0, 0, 6, 0, 0, 8},
{0, 0, 0, 0, 7, 8, 0}
 
};
Graph graph = new Graph(adjacencyMatrix); int src = 0, target = 6;
int maxDepth = 3;
ArrayList<Integer> path = new ArrayList<>();
if (graph.shortestPathIDDFS(src, target, maxDepth, path)) {
System.out.println("Shortest path from " + src + " to " + target + ": " + path);
} else {
System.out.println("No shortest path found within max depth.");
}}}
