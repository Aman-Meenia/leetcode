class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        ArrayList<Integer> adjList[] = new ArrayList[quiet.length];
        
        for (int i = 0; i < richer.length; i++) {
            if (adjList[richer[i][1]] == null) {
                adjList[richer[i][1]] = new ArrayList<>();
            }
            adjList[richer[i][1]].add(richer[i][0]);
        }
        
        int soln[] = new int[quiet.length];
        
        for (int i = 0; i < quiet.length; i++) {
            soln[i] = -1;
        }
        
        for (int i = 0; i < quiet.length; i++) {
            if (soln[i] == -1) {
                soln[i] = dfs(i, quiet, adjList, soln);
            }
        }
        
        return soln;
    }
    
    int dfs(int root, int[] quiet, ArrayList<Integer> adjList[], int[] soln) {
        
        if (soln[root] != -1) {
            return soln[root];
        }
        
        int minPos = root;
        int min = quiet[root];
        if (adjList[root] != null) {
            for (int i = 0; i < adjList[root].size(); i++) {
                int ind = dfs(adjList[root].get(i), quiet, adjList, soln);
                if (quiet[ind] < min) {
                    min = quiet[ind];
                    minPos = ind;
                }
            }
        }
        
        return soln[root] = minPos;
    }
}
