import java.util.LinkedList;
import java.util.Queue;

public class BFSinGraph {

    public void bfs(Graph g, GraphNode start){
        for(GraphNode gn : g.adjacencyMap.keySet()){
            gn.distance = Integer.MAX_VALUE;
        }
        start.distance = 0;
        Queue<GraphNode> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            GraphNode tmp = q.poll();
            for(GraphNode v: g.adjacencyMap.get(tmp)){
                v.distance = tmp.distance + 1;
                q.add(v);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(false);
        GraphNode start = new GraphNode(1,"A");
    }
}
