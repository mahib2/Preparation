public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] adj = new ArrayList[A];
        for (int i=0; i<B.size(); i++) {
            ArrayList<Integer> curEdge = B.get(i);
            int from = curEdge.get(0) - 1;
            int to = curEdge.get(1) - 1;
            if(adj[from] == null) {
                ArrayList<Integer> curList = new ArrayList();
                curList.add(to);
                adj[from] = curList;
            }
            else {
                adj[from].add(to);
            }
        }
        boolean[] visited = new boolean[A];
        Arrays.fill(visited, false);
        return bfs(adj, 0, A-1, visited);
        
    }


    private int bfs(ArrayList<Integer>[] adj, int s, int A, boolean[] visited) {
        if (s==A) {
            return 1;
        }
        visited[s] = true;
        if(adj[s] != null) {
            for (Integer c : adj[s]) {
                if (c==A) {
                    return 1;
                }
                else if (!visited[c]){
                        if (bfs(adj, c, A, visited)==1) return 1;
                }
            }
        }
        return 0;
    }
}
