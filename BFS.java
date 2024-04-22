import java.util.LinkedList; 
import java.util.Queue;

public class BFS { static class Graph {
int vertices;
int[][] adjacencyMatrix;


Graph(int[][] adjacencyMatrix) {
this.adjacencyMatrix = adjacencyMatrix; this.vertices = adjacencyMatrix.length;
}


void shortestPathBFS(int source, int destination) { Queue<Integer> queue = new LinkedList<>(); boolean[] visited = new boolean[vertices];
int[] parent = new int[vertices];
int[] distance = new int[vertices];


visited[source] = true; queue.add(source); parent[source] = -1;
distance[source] = 0;


while (!queue.isEmpty()) {
int currentNode = queue.poll(); if (currentNode == destination) {
break;
 
}
for (int neighbor = 0; neighbor < vertices; neighbor++) {
if (adjacencyMatrix[currentNode][neighbor] != 0 && !visited[neighbor]) { visited[neighbor] = true;
queue.add(neighbor);
parent[neighbor] = currentNode;
distance[neighbor] = distance[currentNode] + 1;

}
}
}


System.out.print("Shortest path from " + source + " to " + destination + ": "); printShortestPath(parent, destination);
System.out.println();
System.out.println("Shortest distance from " + source + " to " + destination + ": " + distance[destination]);
}


void printShortestPath(int[] parent, int destination) { if (parent[destination] == -1) {
System.out.print(destination + " "); return;
}
printShortestPath(parent, parent[destination]); System.out.print(destination + " ");
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


Graph graph = new Graph(adjacencyMatrix); graph.shortestPathBFS(0, 6);
}
}
