package MyPackage;

import javafx.util.Pair;

import java.util.*;

public class Graph {
    boolean[][] adjMatrix;
    int[][] weightMatrix;
    List<List<Integer>> adjList;
    LinkedList<Integer>[] adjArray;
    List<List<Pair<Integer, Integer>>> weightList;
    List<List<Node>> customList;
    Map<Integer, Set<Integer>> adjMap;
    int v;
    static class Node {
        int dest;
        int wieght;
        public Node(int dest, int weight) {
            this.dest = dest;
            this.wieght = weight;
        }
    }
    public Graph(int V) {
        adjMatrix = new boolean[V][V];
        this.v = V;
        weightMatrix = new int[V][V];
        adjList = new ArrayList<>();
        adjArray = new LinkedList[V];
        weightList = new ArrayList<>();
        customList = new ArrayList<>();
        adjMap = new HashMap<>();
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            adjArray[i] = new LinkedList<>();
            weightList.add(new ArrayList<>());
            customList.add(new ArrayList<>());
            adjMap.put(i, new HashSet<>());
        }
    }
    public void printGraphMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Weight Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(weightMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Adjacency List:");
        int k = 0;
        for (List<Integer> list: adjList) {
            System.out.print(k + ":->");
            k++;
            for (Integer i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("Adjacency Array:");
        for (int i = 0; i < v; i++) {
            System.out.print(i + ":->");
            for (Integer adjV: adjArray[i]) {
                System.out.print(adjV + " ");
            }
            System.out.println();
        }
        System.out.println("Weight List");
        k = 0;
        for (List<Pair<Integer, Integer>> list: weightList) {
            System.out.print(k + ":->");
            for (Pair<Integer, Integer> pair: list) {
                System.out.print(pair.getKey()+"::"+ pair.getValue() + " ");
            }
            k++;
            System.out.println();
        }
        System.out.println("Custom List");
        k = 0;
        for (List<Node> list: customList) {
            System.out.print(k + ":->");
            for (Node node: list) {
                System.out.print(node.dest+"::"+ node.wieght+ " ");
            }
            k++;
            System.out.println();
        }
        System.out.println("Adjacency Map");
        for(Map.Entry<Integer, Set<Integer>> entry: adjMap.entrySet()) {
            System.out.print(entry.getKey() + ":->");
            for (Integer value: entry.getValue()) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = true;
        adjList.get(src).add(dest);
        adjArray[src].add(dest);
        adjMap.get(src).add(dest);
    }

    public void addEdge(int src, int dest, int weight) {
        weightMatrix[src][dest] = weight;
        weightList.get(src).add(new Pair(dest, weight));
        customList.get(src).add(new Node(dest, weight));
    }

    public void bfs(int vertex) {
        System.out.println("BFS Traversal of Adj Matrix");
        boolean[] visited = new boolean[this.v];
        Queue<Integer> bfsQ = new LinkedList<>();
        visited[vertex] = true;
        bfsQ.add(vertex);
        while(bfsQ.size() > 0) {
            int src = bfsQ.remove();
            System.out.print(src + " ");
            for (int i = 0; i < v; i++) {
                if (!visited[i] && adjMatrix[src][i]) {
                    visited[i] = true;
                    bfsQ.add(i);
                }
            }
        }
        System.out.println();
        System.out.println("BFS Traversal of Adj List");
        Arrays.fill(visited, false);
        bfsQ.clear();
        visited[vertex] = true;
        bfsQ.add(vertex);
        while (bfsQ.size() > 0) {
            int src = bfsQ.remove();
            System.out.print(src+ " ");
            for (Integer i : adjList.get(src)) {
                if (!visited[i]) {
                    visited[i] = true;
                    bfsQ.add(i);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int vertex) {
        System.out.println("DFS Traversal of Adj Matrix");
        boolean[] visited = new boolean[v];
        dfsUtil(vertex, visited);
        System.out.println();
        System.out.println("DFS Traversal of Adj List");
        Arrays.fill(visited, false);
        dfsList(vertex, visited);
        System.out.println();
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int i = 0; i < v; i++) {
            if (!visited[i] && adjMatrix[vertex][i]) {
                dfsUtil(i, visited);
            }
        }
    }

    private void dfsList(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (Integer adjV : adjList.get(vertex)) {
            if (!visited[adjV]) {
                dfsList(adjV, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(2, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(3, 4);
        g.addEdge(2, 4, 10);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 4, 11);
        g.printGraphMatrix();
        g.bfs(0);
        g.bfs(1);
        g.dfs(0);
        g.dfs(1);
    }
}
