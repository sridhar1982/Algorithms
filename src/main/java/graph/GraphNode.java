package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class GraphNode {

    Map<Integer, Node> nodeMap = new LinkedHashMap<>();

    public Node addNode(int i) {
        if (!nodeMap.containsKey(i)) {
            nodeMap.put(i, new Node(i));
        }
        return nodeMap.get(i);
    }

    public Node addAdjNode(Node parent, Node adj) {
        if (!nodeMap.containsKey(parent.getId())) {
            throw new IllegalStateException("parent node must be created before adding adjacent node");
        }
        if (!nodeMap.containsKey(adj)) {
            nodeMap.put(adj.getId(), adj);
        }
        parent.addAdjacentNode(adj);
        return parent;
    }

    public Collection<Node> getAllNodes() {
        return nodeMap.values();
    }

}


class Node {
        int id;
        private boolean isVisited;
        List<Node> adjacentNodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }

        public Node addAdjacentNode(Node x) {
            this.adjacentNodes.add(x);
            return this;
        }

        public Node(int id, List<Node> adjacentNodes) {
            this.id = id;
            this.adjacentNodes.clear();
            Collections.copy(this.adjacentNodes, adjacentNodes);
        }

        public String toString() {
            return String.valueOf(id);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Node> getAdjacentNodes() {
            return new ArrayList<>(adjacentNodes);
        }

        public void setAdjacentNodes(List<Node> adjacentNodes) {
            Collections.copy(this.adjacentNodes, adjacentNodes);
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void setEdges(List<Edge> edges) {
            Collections.copy(this.edges, edges);
        }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}

class Edge {
        Node from;
        Node to;

        public Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
        }

        public Node getFrom() {
            return from;
        }

        public void setFrom(Node from) {
            this.from = from;
        }

        public Node getTo() {
            return to;
        }

        public void setTo(Node to) {
            this.to = to;
        }
    }

