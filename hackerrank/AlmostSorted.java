import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlmostSorted {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[] = new int[n];
        int i=0;
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(i=1;i<n && arr[i]>=arr[i-1];i++);
        int st=i,end=i;
        for(;i<n&&arr[i]<=arr[i-1];i++);
        end=i;//==n?n-1:i;
        for(;i<n && arr[i]>=arr[i-1];i++);
        if(i!=n || (end<n && arr[st-1]>arr[end]) ||(st>1 && arr[st-2]>arr[end-1])){
            System.out.println("no");
        }else{
            if(end-st+1==2){
                System.out.println("yes\nswap "+st+" "+(end));
            }else{
            System.out.println("yes\nreverse "+(st)+" "+(end));
            }
        }
    }
}