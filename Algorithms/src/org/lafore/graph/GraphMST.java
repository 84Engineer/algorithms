/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lafore.graph;

import java.util.*;

/**
 *
 * @author LocalUser
 */
public class GraphMST {

    public static void main(String[] args) {

        /*Graph g = new Graph(6, 10);
        g.addEdge(1, 2, 6);  // AB  6
        g.addEdge(1, 4, 4);  // AD  4
        g.addEdge(2, 3, 10); // BC 10
        g.addEdge(2, 4, 7);  // BD  7
        g.addEdge(2, 5, 7);  // BE  7
        g.addEdge(3, 4, 8);  // CD  8
        g.addEdge(3, 5, 5);  // CE  5
        g.addEdge(3, 6, 6);  // CF  6
        g.addEdge(4, 5, 12); // DE 12
        g.addEdge(5, 6, 7);  // EF  7

        g.mstw(1);*/
        Graph g = new Graph(5, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 4);
        g.addEdge(4, 2, 6);
        g.addEdge(5, 2, 2);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 5, 7);
        g.mstw(1);

    }

    private static class Graph {

        private final Node[] nodes;
        private final int[][] nMatrix;
        private final PriorityQueue<Edge> edgeQueue;

        public Graph(int nNodes, int nEdges) {
            nodes = new Node[nNodes];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node(i);
            }
            nMatrix = new int[nNodes][nNodes];

            for (int i = 0; i < nMatrix.length; i++) {
                for (int j = 0; j < nMatrix[i].length; j++) {
                    nMatrix[i][j] = Integer.MAX_VALUE;
                }
            }

            edgeQueue = new PriorityQueue(nEdges);
        }

        public void addEdge(int node1, int node2, int weight) {
            nMatrix[node1 - 1][node2 - 1] = weight;
            nMatrix[node2 - 1][node1 - 1] = weight;
        }

        public void mstw(int startNode) {
            int currentNode = startNode - 1;
            int nTree = 0;
            int totalWeight = 0;

            while (nTree < nodes.length - 1) {
                nodes[currentNode].setInTree(true);
                nTree++;

                for (int i = 0; i < nodes.length; i++) {
                    if (i == currentNode) {
                        continue;
                    }
                    if (nodes[i].isInTree()) {
                        continue;
                    }
                    int weight = nMatrix[currentNode][i];
                    if (weight == Integer.MAX_VALUE) {
                        continue;
                    }
                    putInQueue(currentNode, i, weight);
                    if (edgeQueue.isEmpty()) {
                        System.out.println("GRAPH NOT CONNECTED");
                        return;
                    }

                }
                Edge edge = edgeQueue.poll();
                currentNode = edge.getNode2();

                /*System.out.print(edge.getNode1());
                System.out.print(edge.getNode2());
                System.out.print(edge.getWeight());
                System.out.print(" ");*/
                totalWeight += edge.getWeight();

            }

            System.out.println("Total weight: " + totalWeight);

        }

        public void putInQueue(int currentNode, int destNode, int weight) {

            Iterator<Edge> iter = edgeQueue.iterator();

            while (iter.hasNext()) {
                Edge e = iter.next();
                if (e.getNode2() == destNode) {
                    int oldWeight = e.getWeight();
                    if (oldWeight > weight) {
                        iter.remove();
                        edgeQueue.add(new Edge(currentNode, destNode, weight));
                        return;
                    }
                    return;
                }
            }
            edgeQueue.add(new Edge(currentNode, destNode, weight));
        }

    }

    private static class Node {

        private final int number;
        private boolean inTree;

        public Node(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public boolean isInTree() {
            return inTree;
        }

        public void setInTree(boolean inTree) {
            this.inTree = inTree;
        }

    }

    private static class Edge implements Comparable {

        private final int node1;
        private final int node2;
        private final int weight;

        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        public int getNode1() {
            return node1;
        }

        public int getNode2() {
            return node2;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Object o) {
            return getWeight() - ((Edge) o).getWeight();
        }
    }

}
