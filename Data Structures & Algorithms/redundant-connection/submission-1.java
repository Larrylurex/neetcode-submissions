class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int a = find(parents, edge[0]), b = find(parents, edge[1]);
            if (a == b) return edge;

            parents[a] = b;
        }
        return new int[0];

    }

    private int find(int[] parents, int x) {
        while(parents[x] != x) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }
}
