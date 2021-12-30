class Solution {
    public int[] findOrder(int n, int[][] p) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < p.length; i++) {
            if (adjList[p[i][0]] == null) {
                adjList[p[i][0]] = new ArrayList<>();
            }
            adjList[p[i][0]].add(p[i][1]);
        }
        Stack<Integer> stk = new Stack<>();
        int visited[] = new int[n];
        boolean[] st = new boolean[n];
        for (int i = 0; i< n; i++) {
            if (visited[i] == 0) {
                boolean val = dfs(i, stk, visited, adjList, st);
                if (val == false) {
                    return new int[0];
                }
            }
        }
        
        int i = n - 1;
        int soln[] = new int[n];
        while (!stk.isEmpty()) {
            soln[i--] = stk.pop();
        }
        return soln;
    }
    
    private boolean dfs(int node, Stack<Integer> stk, int visited[], List<Integer>[] adjList, boolean[] st) {
        visited[node] = 1;
        st[node] = true;
        if (adjList[node] != null) {
            for (int i = 0; i < adjList[node].size(); i++) {
                if(st[adjList[node].get(i)] == true) {
                    return false;
                }
                if (visited[adjList[node].get(i)] != 1) {
                    boolean val = dfs(adjList[node].get(i), stk, visited, adjList, st);
                    if (val == false) {
                        return false;
                    }
                }
            }
        }
        st[node] = false;
        stk.push(node);
        return true;
    }
}
