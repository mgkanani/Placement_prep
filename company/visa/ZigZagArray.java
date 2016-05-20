import java.util.*;
/*
Zig Zag Array 
*/
public class ZigZagArray{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		arr = zigzag(arr);
		for(int i:arr)
			System.out.print(i+" ");

	}
	public static int[] zigzag(int orig[]){
		int[] arr = new int[orig.length];
		//arr = orig;
		Arrays.sort(orig);
		if(arr.length<=1){
			return orig;
		}
		int cnt = 0,i1=0,i2=orig.length-1;
		int i=0;
		for(i=0 ;i<orig.length/2;i++){
			arr[cnt] = orig[orig.length-i-1];
			cnt++;
			arr[cnt] = orig[i];
			cnt++;
		}
		arr[cnt] = orig[i];
		//if(arr.length)
		return arr;
	}
}