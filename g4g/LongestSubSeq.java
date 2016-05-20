import java.util.*;
/*

The Longest Increasing Subsequence

Problem Statement

An Introduction to the Longest Increasing Subsequence Problems

The task is to find the length of the longest subsequence in a given array of integers such that all elements of the
 subsequence are sorted in ascending order. For example, the length of the LIS for { 15, 27, 14, 38, 26, 55, 46, 65, 85 } is 6 and the longest increasing subsequence is {15, 27, 38, 55, 65, 85}. 

Construction of Longest Monotonically Increasing Subsequence (N log N)

In my previous post, I have explained about longest monotonically increasing sub-sequence (LIS) problem in detail.
However, the post only covered code related to querying size of LIS, but not the construction of LIS.
I left it as an exercise. If you have solved, cheers. If not, you are not alone, here is code.

If you have not read my previous post, read here. Note that the below code prints LIS in reverse order.
We can modify print order using a stack (explicit or system stack). I am leaving explanation as an exercise (easy).
*/
public class LongestSubSeq{

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int arr[] = new int[n];
			int tab[] = new int[n];
			if(n>0)
				tab[0] = Integer.MAX_VALUE;
			int cnt=1,i=0,tmp=0;
			for(i=0;i<n;i++){
				arr[i] = sc.nextInt();
				if(tab[cnt-1]<arr[i]){
					tab[cnt++]=arr[i];
				}else if(tab[cnt-1]>arr[i]){
					tmp = Arrays.binarySearch(tab,0,cnt-1,arr[i]);
					if(tmp<0){
						tab[-(tmp+1)] = arr[i];
					}
				}
			}
			System.out.println(cnt);
	}
}