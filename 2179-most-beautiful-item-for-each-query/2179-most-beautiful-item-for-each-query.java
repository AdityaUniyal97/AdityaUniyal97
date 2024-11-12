import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price to make it easier to process
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Result array to store the maximum beauty for each query
        int[] result = new int[queries.length];

        // Sort queries with their original indices for mapping results
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i]; // Query price limit
            sortedQueries[i][1] = i;          // Original index of the query
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        // Track the maximum beauty seen so far
        int maxBeautySoFar = 0;
        int itemIndex = 0;

        // Process each query in sorted order
        for (int[] query : sortedQueries) {
            int maxPrice = query[0];       // Price limit for this query
            int queryIndex = query[1];     // Original position of this query in queries

            // Process items within the price limit and update max beauty
            while (itemIndex < items.length && items[itemIndex][0] <= maxPrice) {
                maxBeautySoFar = Math.max(maxBeautySoFar, items[itemIndex][1]);
                itemIndex++;
            }

            // Set the result for the current query's original index
            result[queryIndex] = maxBeautySoFar;
        }

        return result;
    }
}
