import java.util.Scanner;
/*
Intution behind this solution:-
 If we replace 0 instead of 3 and 1 instead of 4 then it is actually binary representation.
There is a problem with this replacement as 3,33,333(considered different) => 0,00,000(considered as 0).

Approach :-
1) find out the total number of digits required to represent the solution.
	If we follow the series, it requires 2(for 1 digit),4(2-digits),8, so on,
2) Find out the remainder

e.g. n=12
we do n=11 (as binary start from 0)
now, we subtract the number by 2^1, then 2^2 ,then 2^3 ,... till the number is less the 2^digits.
 11 - 2 - 4 = 5 , 5 < 8

5 => 101(binary) => 434(in 34 representation)

*/
public class Math_Bit_34{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//generate(sc.nextInt());
		int i=0,n = sc.nextInt();
		for(i=0;i<n;i++)
			generate(i+1);
	}
	public static void generate(int n){
		//int n=1;
		int temp,digits,pow2,i;
		temp = n-1;
		digits = 1;
		pow2=2;
		while(temp>=pow2){
			digits++;
			temp-=pow2;
			pow2=pow2<<1;
		}
		StringBuilder br = new StringBuilder(digits);
		pow2=1;
		char c = '\0';
		while(digits>0){
			digits--;
			c=((temp&pow2)==0?'3':'4');
			br.append(c);
			pow2= pow2<<1;
		}
		System.out.println(br.reverse());
	}
}
