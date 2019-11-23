import java.util.LinkedList;
import java.util.Queue;

public class DFSinGraph {
    public void dfs(Graph g){
        for(GraphNode gn: g.adjacencyMap.keySet()){
            gn.visited = false;
        }
        for(GraphNode gn: g.adjacencyMap.keySet()){
            if(!gn.visited)
                helper(g, gn);
        }
    }

    public void helper(Graph g, GraphNode start){
        start.visited = true;

        for(GraphNode v: g.adjacencyMap.get(start)){
            if(!v.visited)
                helper(g, v);
        }
    }
}
