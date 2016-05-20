import java.util.*;
public class Merge_array{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m;
		n = sc.nextInt();
		m = sc.nextInt();
		int i,j,ind=m+n-1;
		int a1[] = new int[n+m];
		int a2[] = new int[m];
		for(i=0;i<n;i++){
			a1[i] = sc.nextInt();
		}
		for(i=0;i<m;i++)
			a2[i] = sc.nextInt();
		i=n-1;
		j=m-1;
		while(i>=0 && j>=0){
			if(a1[i]<a2[j]){
				a1[ind] = a2[j];
				j--;
				ind--;
			}else{
				a1[ind] = a1[i];
				i--;
				ind--;
			}
		}
		while(j>=0){
			a1[j]=a2[j];
			j--;
		}
		for(i=0;i<n+m;i++){
			System.out.print(a1[i]+"\t");
		}
	}
}