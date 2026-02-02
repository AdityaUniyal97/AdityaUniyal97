class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>(); // fruit count
        int l = 0;   // left pointer
        int ans = 0; // answer

        for (int r = 0; r < fruits.length; r++) {

            // add fruit from right
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // more than 2 types -> shrink
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }

            // save longest window
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
