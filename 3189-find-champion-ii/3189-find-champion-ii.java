class Solution {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Initialize a visited array to track targeted nodes
        int[] visited = new int[n]; // All values initially 0 (not visited)

        // Step 2: Process each edge and mark the destination node as visited
        for (int[] edge : edges) {
            visited[edge[1]] = 1; // Mark the node that gets an incoming edge
        }

        // Step 3: Find nodes with visited[i] = 0 (no incoming edges)
        int champion = -1; // To store the index of the potential champion
        int count = 0;     // To count nodes with visited[i] = 0

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                champion = i; // Update the potential champion
                if (count > 1) {
                    return -1; // More than one node with no incoming edges
                }
            }
        }

        // Step 4: Return the result
        return count == 1 ? champion : -1; // Return the unique champion, or -1 if none
    }
}
