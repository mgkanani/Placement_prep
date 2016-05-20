/*
Given an array of integers, find the maximum continuous sum such that no elements contributing to the sum, are repeated.

*/
import java.util.*;
public class MaxContSum{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
		int n = sc.nextInt();
		int arr[] = new int[n];
		int max=Integer.MIN_VALUE;
		for(int j=0;j<n;j++){
			arr[j]=sc.nextInt();
			if(max<arr[j]){
				max = arr[j];
			}
		}
		int l_st=0,l_end=0,sum=0;
		for(int j=0;j<n;j++){
			if(mp.containsKey(arr[j])){
				if(sum>max){
					max=sum;
				}				
				l_end = mp.get(arr[j]);
				for(;l_st<=l_end;l_st++){
					sum-=arr[l_st];
					mp.remove(arr[l_st]);
				}
				sum+=arr[j];
				//l_st=l_end+1;
				mp.put(arr[j],j);
			}else{
				sum+=arr[j];
				mp.put(arr[j],j);
			}
		}
		if(sum>max)
			max=sum;
		System.out.println(max);
	}
}