class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int n = height.length;
        int res = 0;

        int[] lMax = new int[n];
        lMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }

        int[] rMax = new int[n];
        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return res;
    }
}
