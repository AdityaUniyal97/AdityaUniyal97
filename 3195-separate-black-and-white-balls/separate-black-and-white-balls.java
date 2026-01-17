class Solution {
    public long minimumSteps(String s) {
        long swap = 0;
        int left = 0;
        for(int right = 0 ; right < s.length() ; right++){
            if(s.charAt(right) == '0'){
                swap += (right - left);
                left++;
            }
        }
        return swap;
    }
}