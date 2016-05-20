import java.util.*;
/*
given array of non-negative integers and a target integer, 
find the number of ways you can make the target integer using
 all the integers from the array and in the same sequence. 
 you are only allowed to use + or - operator between two elements .
  ( 1<= n <= 50,000  ) n is the size of array

*/
public class Ways{
	//static int dp[][];
	static HashMap<String,Integer> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int i,M=sc.nextInt();
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		map = new HashMap<String,Integer>();
		System.out.println(ways(arr,0,M));
	}
	public static int ways(int[] arr, int i, int m){
		if(i>arr.length)
			return 0;
		else if(i==arr.length){
			return m==0?1:0;
		}else if(!map.containsKey(i+"#"+m)){
			int val = ways(arr,i+1,m-arr[i]) + ways(arr,i+1,m+arr[i]);
			map.put(i+"#"+m,val);
			return val;
		}else{
			return map.get(i+"#"+m);
		}
	}
}