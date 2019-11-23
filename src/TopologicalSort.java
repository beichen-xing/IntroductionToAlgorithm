import java.util.Stack;

public class TopologicalSort {

    private boolean[] marked;
    Stack<GraphNode> reversePost;

    public TopologicalSort(Graph g){
        reversePost = new Stack<>();
        marked = new boolean[g.adjacencyMap.size()];
        for(GraphNode gn : g.adjacencyMap.keySet())
            if(!gn.visited) dfs(g, gn);
    }

    private void dfs(Graph g, GraphNode v){
        v.visited = true;
        for(GraphNode i : g.adjacencyMap.get(v))
            if(!i.visited) dfs(g, i);
        reversePost.push(v);
    }
}
