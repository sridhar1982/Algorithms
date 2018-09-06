package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * cycle detection in Undirected cyclic graph
 * this one has two cycles
 */
public class CycleDetectionDirectedGraph {

    public static void main(String[] args) {

        GraphNode g = new GraphNode();
        Node one = g.addNode(1);
        Node two = g.addNode(2);
        Node three = g.addNode(3);
        Node four = g.addNode(4);
        Node five = g.addNode(5);

        g.addAdjNode(one, two);
        g.addAdjNode(three, one);
        g.addAdjNode(two, four);
        g.addAdjNode(two, three);
        g.addAdjNode(four, five);
        g.addAdjNode(five, two);

        System.out.println(hasCycles(g));

        //no cycle graph
        GraphNode g1 = new GraphNode();
        Node six = g1.addNode(6);
        Node seven = g1.addNode(7);
        Node eight = g1.addNode(8);

        g1.addAdjNode(six, seven);
        g1.addAdjNode(seven, eight);
        System.out.println(hasCycles(g1));



    }

    public static boolean hasCycles(GraphNode g) {

        Collection<Node> nodes = g.getAllNodes();
        Set<Node> set = new HashSet<>();
        Map<Node, Node> parent = new HashMap();

        for (Node n : nodes) {
            if (!n.isVisited()) {
                if (isCyclic(n, set, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean  isCyclic(Node n, Set<Node> currentlyVisitingNodes, Map<Node, Node> parent ) {

        if (currentlyVisitingNodes.contains(n)) {
            processParentMap(n, parent);
            return true;
        }

        n.setVisited(true);
        currentlyVisitingNodes.add(n);
        for (Node adj : n.getAdjacentNodes()) {
            parent.put(n, adj);
            if (isCyclic(adj, currentlyVisitingNodes, parent)) {

                return true;
            }
        }
        currentlyVisitingNodes.remove(n);
        return false;
    }

    public static void processParentMap(Node adj, Map<Node, Node> parent) {
        Node temp = parent.get(adj);
        String result = adj.getId() + " ";
        while (temp!=adj) {
            result+=temp.getId() + " ";
            temp = parent.get(temp);
        }
        System.out.println(result);
    }


}
