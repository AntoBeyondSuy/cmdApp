package com.leetcode;

public class FindCircleNum {
    int le = 0;
    public int findCircleNum(int[][] isConnected) {
        le = isConnected.length;
        boolean[] visited = new boolean[le];
        int circlen = 0;
        for (int i = 0; i < le; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                circlen++;
            }
        }
        return circlen;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < le; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }


}



