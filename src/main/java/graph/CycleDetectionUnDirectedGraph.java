package graph;


import java.util.Collection;
import java.util.List;

/**
 * cycle detection in Undirected cyclic graph
 */
public class CycleDetectionUnDirectedGraph {

    public static void main(String[] args) {

        //undirected graph
        GraphNode g = new GraphNode();
        Node one = g.addNode(1);
        Node two = g.addNode(2);
        Node three = g.addNode(3);
        Node four = g.addNode(4);
        Node five = g.addNode(5);

        g.addAdjNode(one, two);
        g.addAdjNode(two, one);
        g.addAdjNode(one, three);
        g.addAdjNode(three, one);
        g.addAdjNode(three, two);
        g.addAdjNode(two, three);
        g.addAdjNode(four, five);
        g.addAdjNode(five, four);
        g.addAdjNode(two, four);
        g.addAdjNode(four, two);
        g.addAdjNode(two, five);
        g.addAdjNode(five, two);


        GraphNode g1 = new GraphNode();
        Node six = g1.addNode(6);
        Node seven = g1.addNode(7);
        g1.addAdjNode(six, seven);
        g1.addAdjNode(seven, six);

        GraphNode g2 = new GraphNode();
        Node eight = g2.addNode(8);
        eight.addAdjacentNode(eight);



        System.out.println(hasCyclesUnDirected(g));
        System.out.println(hasCyclesUnDirected(g1));
        System.out.println(hasCyclesUnDirected(g2));
    }

    public static boolean hasCyclesUnDirected(GraphNode graphNode) {
        Collection<Node> nodes = graphNode.getAllNodes();

        for (Node n : nodes) {
            if (!n.isVisited()) {
                if (isCyclicUnDirected(n, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclicUnDirected(Node n, Node parent) {

        if (n.isVisited()) {
            return true;
        }
        n.setVisited(true);
        List<Node> adj =  n.getAdjacentNodes();

        adj.remove(parent);
       for (Node p : adj) {
           if (isCyclicUnDirected(p, n)) {
               return true;
           }
       }
        return false;
    }

}
