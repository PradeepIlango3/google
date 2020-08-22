package MyPackage;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    boolean[][] adjMatrix;
    int[][] weightMatrix;
    List<List<Integer>> adjList;
    LinkedList<Integer>[] adjArray;
    List<List<Pair<Integer, Integer>>> weightList;
    List<List<Node>> customList;
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
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            adjArray[i] = new LinkedList<>();
            weightList.add(new ArrayList<>());
            customList.add(new ArrayList<>());
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
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = true;
        adjList.get(src).add(dest);
        adjArray[src].add(dest);
    }

    public void addEdge(int src, int dest, int weight) {
        weightMatrix[src][dest] = weight;
        weightList.get(src).add(new Pair(dest, weight));
        customList.get(src).add(new Node(dest, weight));
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
    }
}
