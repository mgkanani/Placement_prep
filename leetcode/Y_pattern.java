import java.util.*;
public class Y_pattern{
	public static void PR(Object obj){
		System.out.print(obj);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<2)
			PR("not possible \n");
		int n1 = (2*(n/2)+1);
		char arr[][] = new char[n][n1];
		for(char c[]:arr)
			for(int i=0;i<c.length;i++)
				c[i] = ' ';
		
		for(int i=n/2;i<n;i++){
			arr[i][n1/2] = '*';
		}
		for(int i=n/2 -1; i>=0;i--){
			arr[i][i]='*';
			arr[i][n1-1-i]='*';
		}
		for(char[] c: arr)
			PR(new String(c) +"\n");
	}
}