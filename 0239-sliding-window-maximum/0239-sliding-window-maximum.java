class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Handles invalid cases : empty array , null array , or invalid
        if(nums == null || nums.length == 0 || k > nums.length)
        {
            return new int[0]; // Return an impty array
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1]; // Array to store the result
        int ri = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            // Remove elements outside the current window
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1)
            {
                deque.pollFirst();//Remove from Fornt
            }

            // Remove the element smaller than the current element from the back of the deque
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            {
                deque.pollLast(); // Kick out smaller element
            }
            //Add the current element index to the deque
            deque.offerLast(i);
            //Once the first window is fully forword start recording result
            if(i >= k - 1)
            {
                result[ri++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}