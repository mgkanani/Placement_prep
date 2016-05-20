import java.util.*;
public class Missing{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int i;
		int xor1=0;
		for(i=0;i<n;i++){
			arr[i] = sc.nextInt();
			xor1 = xor1^arr[i];
		}
		int xor2=0;
		for(i=1;i<=n;i++){
			xor2 = xor2^i;
		}
		int res=xor1^xor2;
		int temp=1;
		while((res&1)!=1){
			res = res>>1;
			temp = temp<<1;
		}
		xor1=0;
		xor2=0;
		for (i=1;i<=n; i++) {
			if((i&temp)>0){
				xor1 = xor1^i;
			}else{
				xor2 = xor2^i;
			}
			if((arr[i-1]&temp)>0){
				xor1 ^= arr[i-1];
			}else{
				xor2 ^= arr[i-1];
			}
		}
		System.out.println(xor1+"\t"+xor2);
	}
}