class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // If there are no cookies , return 0
        if(s == null || s.length == 0)
        {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while(i < g.length && j < s.length)
        {
            // If the currenct cookies can satisfy the current child
            if(s[j] >= g[i])
            {
                i++; //  Move to the next child
            }
            j++;
        }
        return i;
    }
}