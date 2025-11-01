class Solution {
    public int minimumRecolors(String blocks, int k) {
       int  cw = 0;
        for(int i = 0 ; i < k ; i++){
            if(blocks.charAt(i) == 'W'){
                cw++;
            }
        }

        int res = cw;
        for(int i = k ; i < blocks.length() ; i++){
            if(blocks.charAt(i - k) == 'W'){
                cw--;
            }

            if(blocks.charAt(i) == 'W'){
                cw++;
            }
            res = Math.min(res , cw);
        }
        return res;
    }
}