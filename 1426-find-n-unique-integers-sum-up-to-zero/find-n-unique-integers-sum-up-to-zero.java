class Solution {
    public int[] sumZero(int n) {
        int[]res=new int[n];
        int s = 1;
        int e = n - 1;
        int l = 0;
        while(l < e){
            res[l++] = s;
            res[e--] = -s;
            s++;
        }
        return res;
    }

}