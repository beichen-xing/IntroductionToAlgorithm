import java.util.*;

class GraphNode{
    int val;
    String name;
    int distance;
    boolean visited;

    public GraphNode(int v, String name){
        this.val = v;
        this.name = name;
    }
}
public class Graph {
    HashMap<GraphNode, LinkedList<GraphNode>> adjacencyMap;
    boolean directed;


    public Graph(boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public void addEdgeHelper(GraphNode a, GraphNode b){
        LinkedList<GraphNode> tmp = adjacencyMap.get(a);

        if(tmp != null){
            tmp.remove(b);
        }else{
            tmp = new LinkedList<>();
        }
        tmp.add(b);
        adjacencyMap.put(a, tmp);

    }
    public void addEdge(GraphNode source, GraphNode destination){

        if(!adjacencyMap.keySet().contains(source))
            adjacencyMap.put(source,null);

        if(!adjacencyMap.keySet().contains(destination))
            adjacencyMap.put(destination, null);

        addEdgeHelper(source, destination);

        if(!directed)
            addEdgeHelper(destination, source);
    }

    public void printEdges(){
        for(GraphNode node : adjacencyMap.keySet()){
            System.out.println(node.name + "has");
            for(GraphNode neighbor: adjacencyMap.get(node)){
                System.out.println(neighbor.name);
            }
        }
    }
}

