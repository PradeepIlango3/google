package MyPackage;

import javafx.util.Pair;

import java.util.*;
import java.util.Stack;

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

    public int[] spBfs(int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        boolean[] visited = new boolean[v];
        visited[src] = true;
        while (q.size() > 0) {
            int vertex = q.remove();
            for (Integer adjV: adjList.get(vertex)) {
                if (!visited[adjV]) {
                    visited[adjV] = true;
                    dist[adjV] = dist[vertex] + 1;
                    q.add(adjV);
                }
            }
        }
        return dist;
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

    public void printTopologicalSort() {
        boolean[] visited = new boolean[v];
        java.util.Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v ; i++) {
            if (!visited[i]) {
                topoDfs(i, stack, visited);
            }
        }
        System.out.println("Topological Sort:");
        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void topoDfs(int i, Stack<Integer> stack, boolean[] visited) {
        visited[i] = true;
        for (Integer adjV: adjList.get(i)) {
            if (!visited[adjV]) {
                topoDfs(adjV, stack, visited);
            }
        }
        stack.push(i);
    }

    public int[] dijkstra(int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dist[o1] - dist[o2];
            }
        });
        dist[src] = 0;
        pq.add(src);
        while (!pq.isEmpty()) {
            int vertex = pq.remove();
            for (Pair<Integer, Integer> adjV: weightList.get(vertex)) {
                if ((dist[vertex] + adjV.getValue()) < dist[adjV.getKey()]) {
                    dist[adjV.getKey()] = dist[vertex] + adjV.getValue();
                }
            }
        }
        return dist;
    }

    public int[] topoSp(int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Stack<Integer> topo = new Stack<Integer>();
        topoDfs(src, topo, new boolean[v]);
        dist[src] = 0;
        while(!topo.empty()) {
            int vertex = topo.pop();
            if (dist[vertex] != Integer.MAX_VALUE) {
                for (Pair<Integer, Integer> adjV: weightList.get(vertex)) {
                    if ((dist[vertex] + adjV.getValue()) < dist[adjV.getKey()]) {
                        dist[adjV.getKey()] = dist[vertex] + adjV.getValue();
                    }
                }
            }
        }
        return dist;
    }

    public int[] bellman(int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int s = 0;
        for (int i = 0 ; i < v-1; i++) {
            s = 0;
            for (List<Pair<Integer, Integer>> adjList: weightList) {
                for (Pair<Integer, Integer> adjV : adjList) {
                    if (dist[s] != Integer.MAX_VALUE) {
                        if (dist[s] + adjV.getValue() < dist[adjV.getKey()]) {
                            dist[adjV.getKey()] = dist[s] + adjV.getValue();
                        }
                    }
                }
                s++;
            }
        }
        return dist;
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
        g.printTopologicalSort();
        int dist[] = g.spBfs(0);
        System.out.println("Shortest distance from source vertex : " + 0);
        for (int i: dist) {
            System.out.print(i + " ");
        }
        System.out.println();
        int dista[] = g.spBfs(1);
        System.out.println("Shortest distance from source vertex : " + 1);
        for (int i: dista) {
            System.out.print(i + " ");
        }
        System.out.println();
        int distb[] = g.dijkstra(1);
        System.out.println("Shortest distance from source vertex using dijkstra : " + 1);
        for (int i: distb) {
            System.out.print(i + " ");
        }
        System.out.println();
        int distc[] = g.dijkstra(2);
        System.out.println("Shortest distance from source vertex using dijkstra : " + 2);
        for (int i: distc) {
            System.out.print(i + " ");
        }
        System.out.println();
        int distd[] = g.dijkstra(1);
        System.out.println("Shortest distance from source vertex using DAG : " + 1);
        for (int i: distd) {
            System.out.print(i + " ");
        }
        System.out.println();
        int diste[] = g.dijkstra(2);
        System.out.println("Shortest distance from source vertex using DAG : " + 2);
        for (int i: diste) {
            System.out.print(i + " ");
        }
        System.out.println();
        g.addEdge(3, 2, -1);
        int distf[] = g.bellman(1);
        System.out.println("Shortest distance from source vertex using DAG : " + 1);
        for (int i: distf) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
