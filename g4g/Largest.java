import java.util.*;
/*
Largest sum continuos array
*/
public class Largest{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sum=0,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		if(n>=1){
			sum = 0;
			for(int i:arr){
				if(sum>=0){
					sum+=i;
				}else{
					sum = i;
				}
				if(sum>max){
					max=sum;
				}
			}
			System.out.println(max);
		}
		else
			System.out.println(0);
	}
}