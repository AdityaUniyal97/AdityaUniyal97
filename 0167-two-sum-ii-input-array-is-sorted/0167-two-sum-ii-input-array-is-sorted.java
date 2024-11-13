class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j)
        {
            int sum = numbers[i] + numbers[j];
            if(sum == target)
            {
                return new int[] {i + 1, j + 1}; // returning accoridng to the 1 based indexing 
            }
            else if(sum < target)
            {
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}