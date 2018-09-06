package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 *  A  ------ --- *B
 *  * \            |   directed graph A->B->C->D->A ; D->E and A-> E exists
 *  |  *E          |   This graph is directed cyclic graph. Two path exists between B and C; B-C-D-E & B-C-D-A-E
 *  | /            *    shortest path will be B-C-D-E
 *  D * ---------- C    even if the graph is acylic, that is A -B path does not exist, shortes path still remains  B-C-D-E
 *
 *  The problem is to compute this shortest path
 *
 *  undirected graph is simpler. same logic can be used
 **/

public class ShortestPath {

    public static void main(String[] args) {

        GraphNode graphNode = new GraphNode();
        Node a = graphNode.addNode(1);
        Node b = graphNode.addNode(2);
        Node c = graphNode.addNode(3);
        Node d = graphNode.addNode(4);
        Node e = graphNode.addNode(5);
        Node f = graphNode.addNode(6);

        graphNode.addAdjNode(a, b);
        graphNode.addAdjNode(b, c);
        graphNode.addAdjNode(c, d);
        graphNode.addAdjNode(d, e);
        graphNode.addAdjNode(d, a);
        graphNode.addAdjNode(d, f);
        graphNode.addAdjNode(a, e);



//
//        a.addAdjacentNode(b);
//        b.addAdjacentNode(c);
//        c.addAdjacentNode(d);
//        d.addAdjacentNode(e).addAdjacentNode(a).addAdjacentNode(f);
//        a.addAdjacentNode(e);

        shortestPathBFS(b, e);
        shortestPathBFS(d, e);
        shortestPathBFS(a, f);

        //Node



    }

    public static void shortestPathBFS(Node src, Node dest) {
        //keep track of child -> parent as (k,v) in hashMap
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> tobeVisited = new LinkedList<>();
        //parent of src is null
        map.put(src, null);
        tobeVisited.add(src);

        while (!tobeVisited.isEmpty()) {

            Node curr = tobeVisited.poll();
            if (curr == dest) {
                break;
            }
            for (Node adj : curr.getAdjacentNodes()) {
                // we dont want to revisit nodes again and again, especially when it is cyclic. it goes into infinite loop
                if (!map.containsKey(adj)) {
                    map.put(adj, curr);
                    tobeVisited.add(adj);
                }
            }
        }

        if (map.get(dest) == null) {
            System.out.println(String.format("no route between %s and %s", src, dest));
            return;
        }
        List<Node> result = new LinkedList<>();
        Node temp = dest;
        while(temp != null) {
            result.add(0, temp);
            temp = map.get(temp);
        }
        System.out.println(result);
        return;
    }

}
