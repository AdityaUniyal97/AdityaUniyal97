// InputCopy
// 8 5
// 10 9 8 7 7 7 5 5
// OutputCopy
// 6
import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int pos = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.println(helper(arr , pos));
    }
    
    public static int helper(int[] arr , int k){
        int ele = 0;
        int count = 0;
        for(int i = 0 ; i < k ; i++){
            if(i == k - 1){
                ele = arr[i];
            }
        }
        
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] >= ele && arr[i] > 0){
                count++;
            }
        }
        
        return count;
    }
}