import java.util.HashMap;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false; // Edge case handling
        }

        // Map to store buckets
        HashMap<Long, Long> buckets = new HashMap<>();
        long bucketSize = (long) t + 1; // Bucket size is t + 1

        for (int i = 0; i < nums.length; i++) {
            long bucketID = getBucketID(nums[i], bucketSize);

            // Check if the current bucket already contains a number
            if (buckets.containsKey(bucketID)) {
                return true;
            }

            // Check adjacent buckets for possible matches
            if (buckets.containsKey(bucketID - 1) && Math.abs(nums[i] - buckets.get(bucketID - 1)) <= t) {
                return true;
            }
            if (buckets.containsKey(bucketID + 1) && Math.abs(nums[i] - buckets.get(bucketID + 1)) <= t) {
                return true;
            }

            // Add the current number to its bucket
            buckets.put(bucketID, (long) nums[i]);

            // Maintain the sliding window: remove numbers that fall out of range
            if (i >= k) {
                long oldBucketID = getBucketID(nums[i - k], bucketSize);
                buckets.remove(oldBucketID);
            }
        }

        return false; // No match found
    }

    // Helper method to calculate bucket ID
    private long getBucketID(long num, long bucketSize) {
        return num < 0 ? (num + 1) / bucketSize - 1 : num / bucketSize;
    }
}
