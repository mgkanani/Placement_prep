import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
Stock Maximize
*/
public class StockMax {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int itr=0,i=0;
        while(itr<T){
            int n = Integer.parseInt(sc.nextLine());
            long arr[] = new long[n];
            i=0;
            for(String str:sc.nextLine().split(" ")){
                arr[i] = Integer.parseInt(str);
                i++;
            }
            long sum=0,acc=0;
            i=1;
            int j=0;
            int max_i[] = new int[n];
            long max=arr[n-1];
            max_i[n-1]=-1;
            for(i=n-2;i>=0;i--){
                if(arr[i]>max){
                    max_i[i] = -1;
                    max=arr[i];
                }
            }
            i=0;
            while(i<n){
                j=i;
                acc=0;
                while(j<n && max_i[j]!=-1){acc+=arr[j];j++;}
                if(i!=j && j<n){
                    sum+=(j-i)*arr[j] - acc;
                    i=j;
                    while(i<n && max_i[i]==-1){i++;}
                }else{
                    i++;                 
                }
            }
            System.out.println(sum);
            itr++;
        }
    }
}