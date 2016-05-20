import java.util.*;
import java.math.BigInteger;	
/*
http://assessments.firstnaukri.com/TE/8839990
*/
public class A{
	public static void PR(Object obj) { System.out.print(obj); }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int i=0,num,digits=0;
		StringBuilder br = new StringBuilder(m*10);
		long temp=0;
		BigInteger big;
		while(i<m){
			num = sc.nextInt();
			br.append(check(num)+"\n");
			i++;
		}
		PR(br);
	}
	public static int check(long num){
		BigInteger big;
		int i,j;
		StringBuilder br;
		for(i=1;;i++){
			br = new StringBuilder(i);
			for(j=0;j<i;j++)
				br.append("0");
			for(j=0;j<i;j++){
				br.setCharAt(j,'4');
				//PR(br+"\n");
				if(((new BigInteger(br.toString())).mod(BigInteger.valueOf(num)).equals(BigInteger.ZERO))) {
					return (j+1)*2+(i-j-1);
				}
			}
		}
	}
}