// Examples
// InputCopy
// 2 4
// OutputCopy
// 4
import java.util.*;
public class Main{
    public static int helper(int m , int n){
        int ans = m * n;
        return ans / 2;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(helper(m,n));
    }
}