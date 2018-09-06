package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * topSort for build ordering. can be used to detect cycles
 */
public class TopSort {

    public static void main(String[] args) {

        TopSort ts = new TopSort();

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

        //System.out.println(ts.topSort(g));

        GraphNode g1 = new GraphNode();
        Node nine = g1.addNode(9);
        Node ten = g1.addNode(10);
        Node eleven = g1.addNode(11);
        Node twelve = g1.addNode(12);
        Node six = g1.addNode(6);
        Node seven = g1.addNode(7);
        Node eight = g1.addNode(8);


        g1.addAdjNode(seven, six);
        g1.addAdjNode(eight, six);
        g1.addAdjNode(nine, seven);
        g1.addAdjNode(ten, eight);
        g1.addAdjNode(eleven, nine);
        g1.addAdjNode(eleven, ten);
        g1.addAdjNode(twelve, eleven);

        System.out.println(ts.topSort(g1));
    }



    //using visited and visiting hashsets
    //Also used for Topologica sorting
    public List<Node> topSort(GraphNode g) {
        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> visitingNodes = new HashSet<>();
        List<Node> result = new LinkedList<>();

        for (Node n : g.getAllNodes()) {
            if (!visitedNodes.contains(n)) {
                topSort(n, visitedNodes, visitingNodes, result);
            }
        }
        return result;
    }

    public void topSort(Node n, Set<Node> visitedNodes, Set<Node> visitingNodes, List<Node> result) {

        if (visitingNodes.contains(n)) {
            throw new RuntimeException("cycle found");
        }

        if (!visitedNodes.contains(n)) {
            visitingNodes.add(n);
            for (Node adj : n.getAdjacentNodes()) {
                topSort(adj, visitedNodes, visitingNodes, result);
            }
            visitedNodes.add(n);
            visitingNodes.remove(n);
            result.add(n);
        }
    }
}
