import java.util.Scanner;
/*
ount total set bits in all numbers from 1 to n
*/
public class Count_Total_SetBits{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		//generate(sc.nextInt());
		int i=0,n = sc.nextInt();
		for(i=0;i<=n;i++)
			System.out.println("counts till number "+i+" is:- "+count(i));
	}
	public static int count(int n){
		if(n<0)
			return 0;
		if(n<3)
			return n;
		int b=0,temp=n;
		while(temp>1){
			b++;
			temp = temp>>1;
		}
		temp = 1<<b;
		//System.out.println("n="+n+"\tb="+b+"\t temp="+temp);
		if(n==((temp<<1)-1))
			return (b+1)*(temp);
		return b*(temp>>1) + (n - temp + 1) + count(n-temp);
		// total 1's till b width + total set msb for remaining numbers + count of bits from temp to n(excluding msb bit)
	}
}
