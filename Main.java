import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        for(int i = 1; i <= k; i++){  
                int j, first;  
                first = arr[0];  
                for(j = 0; j < n-1; j++){  
                    arr[j] = arr[j+1];  
                }
                arr[j] = first;  
            }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}