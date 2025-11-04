class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        for(int j = 0 ; j <=  n - m ; j++){
            int i = 0;
            while(i < m && haystack.charAt(j + i) == needle.charAt(i)){
                i++;
            }

            if(i == m){
                return j;
            }
        }
        return -1;
    }
}