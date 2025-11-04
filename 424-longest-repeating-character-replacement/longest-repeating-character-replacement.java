class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        int maxLen = 0;
        int[] freq = new int[26];
        int res= 0 ;
        for(int right = 0 ; right < s.length() ; right++){
            freq[s.charAt(right)-'A']++;
            maxLen = Math.max(maxLen , freq[s.charAt(right) - 'A']);
            while((right - low + 1) - maxLen > k){
                freq[s.charAt(low)-'A']--;
                low++;
            }
            res = Math.max(res,  right - low + 1);
        }
        return res;
    }
}