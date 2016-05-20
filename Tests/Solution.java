/*
844661
teststu_06247
cc116350
seconds ticks hour
*/
import java.util.*;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str[] = sc.next().split(":");
		int sec=0;
		if(str.length==3){
			sec+=Integer.parseInt(str[2]);
			sec+=Integer.parseInt(str[1])*60;
			sec+=Integer.parseInt(str[0])*60*60;
		}
		int x=gcd(sec,100);
		int y = 100/x;
		System.out.println(100/y - 1);
	}
	public static int gcd(int x, int y){
		if(x<y)
			return gcd(y,x);
		if(x==y||y==0)
			return x;
		return gcd(y,x%y);
	}
}