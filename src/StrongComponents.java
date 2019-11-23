public class StrongComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    public StrongComponents(Graph g){

        marked = new boolean[g.adjacencyMap.size()];
// here g should reverse first
        TopologicalSort tp = new TopologicalSort(g);

        for(GraphNode gn : tp.reversePost){
            if(!gn.visited){
                dfs(g, gn);
                count++;
            }
        }
    }
// part2 dfs
    private void dfs(Graph g, GraphNode v){
        v.visited = true;
        id[v.val] = count;
        for(GraphNode i : g.adjacencyMap.get(v))
            if(!i.visited) dfs(g, i);
    }

    public boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }
}
