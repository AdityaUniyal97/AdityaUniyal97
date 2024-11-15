class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
     int n = arr.length;
     int left = 0;
     while(left < n - 1 && arr[left] <= arr[left + 1])
     {
        left++;
     }   

     // If the entire array is already sorted
     if(left == n - 1)
     {
        return 0;
     }

     // Find the longest sorted suffix
     int right = n - 1;
     while(right > 0 && arr[right - 1] <= arr[right])
     {
        right--;
     }
     // calcualte the minimum length to remove
     int result = Math.min(n - left - 1, right);

     int i =0 ;
     int j = right;
     while(i <= left && j < n)
     {
        if(arr[i] <= arr[j])
        {
            result = Math.min(result , j - i  - 1);
            i++;
        }
        else{
            j++;
        }
     }
     return result;
    }
}