import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
    int n,k;
    n = sc.nextInt();
    k = sc.nextInt();
    int i;
    int a[] = new int[k];
    for(i=0;i<k;i++)
        a[i]=sc.nextInt();
    Arrays.sort(a);
    int cnt=0;
    int tmp;
    tmp = a[0] - 2;
    cnt+=(tmp+1)/2;
    for(i=1;i<k;i++){
        tmp = a[i] - a[i-1] -3;
        cnt+=(tmp+1)/2;
    }
    tmp = n-a[k-1]-1;
    cnt+=(tmp+1)/2;
    System.out.println(cnt+k);
    }
}
