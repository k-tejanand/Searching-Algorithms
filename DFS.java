import java.util.*; 
public class DFS {
static class Graph {
int[][] adjacencyMatrix; 
int vertices;
List<Integer> shortestPath;
Graph(int[][] adjacencyMatrix) {
this.adjacencyMatrix = adjacencyMatrix; this.vertices = adjacencyMatrix.length; this.shortestPath = new ArrayList<>();
}


void DFSUtil(int v, int destination, boolean[] visited, List<Integer> path) { visited[v] = true;
path.add(v);


if (v == destination) {
if (shortestPath.isEmpty() || path.size() < shortestPath.size()) { shortestPath = new ArrayList<>(path);
}
}


for (int i = 0; i < vertices; i++) {
if (adjacencyMatrix[v][i] != 0 && !visited[i]) { DFSUtil(i, destination, visited, path);
}
}

path.remove(path.size() - 1);
 
visited[v] = false;
}


List<Integer> findShortestPath(int start, int destination) { boolean[] visited = new boolean[vertices];
List<Integer> path = new ArrayList<>(); DFSUtil(start, destination, visited, path); return shortestPath;
}
}


public static void main(String[] args) { int[][] adjacencyMatrix = {
{0, 2, 3, 0, 0, 0, 0},
{2, 0, 0, 4, 0, 0, 0},
{3, 0, 0, 0, 5, 0, 0},
{0, 4, 0, 0, 0, 6, 0},
{0, 0, 5, 0, 0, 0, 7},
{0, 0, 0, 6, 0, 0, 8},
{0, 0, 0, 0, 7, 8, 0}

};


Graph graph = new Graph(adjacencyMatrix); int start = 0;
int destination = 6;
List<Integer> shortestPath = graph.findShortestPath(start, destination); if (!shortestPath.isEmpty()) {
System.out.println("Shortest Path from " + start + " to " + destination + ": " + shortestPath);
} else {
 
System.out.println("No path exists between " + start + " and " + destination);
}}}
