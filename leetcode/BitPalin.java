/*
Given a number, return the number of set bits of the number if binary representation of the number is a palindrome, else return -1. 
Condition : You can’t use array or any other data structure.
*/
import java.util.*;
public class BitPalin{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if((n&1)==0){
			System.out.println(-1);
			return;
		}else if(n==0){
			System.out.println(0);
			return;
		}
		else if(n==1){
			System.out.println(1);
			return;
		}
		int msb=1,t1=n;
		int iter=0;
		while(t1>1){
			t1>>=1;
			msb<<=1;
			iter++;
		}
		t1=n;
		int cnt=0;
		int i=msb,j=1;
		while(i>j){
			if((n&i)>0 && (n&j)>0){
				cnt+=2;
			}else if((n&i)==0 && (n&j)==0){
			}else{
				System.out.println(-1);
				return;
			}
			i>>>=1;
			j<<=1;
		}
		if(i==j && (n&i)>0){
			cnt++;
		}
		System.out.println(cnt);
	}
}