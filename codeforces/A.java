import java.util.*;
public class A{
	public static void main(String arg[]){
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int i;
		for(i=0;i<n;i++)
			a[i] = sc.nextInt();
		int out[][] = new int[n][2];
		if(n>1){
			out[0][0]= a[1]-a[0];
			out[0][1]= a[n-1]-a[0];
			out[n-1][0] = a[n-1]-a[n-2];
			out[n-1][1] = a[n-1]-a[0];
			for(i=1;i<n-1;i++){
				out[i][0]= Math.min(a[i]-a[i-1],a[i+1]-a[i]);
				out[i][1]= Math.max(a[i]-a[0],a[n-1]-a[i]);
			}
		}
		for(i=0;i<n;i++)
			System.out.println(out[i][0]+" "+out[i][1]);
	}
}
