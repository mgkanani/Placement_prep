import java.util.*;
public class B{
	public static void main(String args[]){
		int T=0;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0;i<T;i++){
			int v,d;
			v=sc.nextInt();
			d=sc.nextInt();
			double res = (double)(9.8*d)/(v*v);
			System.out.println(res);
			System.out.println((float)(180*Math.asin(res)/(2*Math.PI)));
		}
	}
}
