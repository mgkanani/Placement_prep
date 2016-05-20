import java.util.*;

public class Floyd{
	public static void PRINT(Object obj){ System.out.print(obj);}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,q,x,y,r;
		n = sc.nextInt();
		m = sc.nextInt();
		int i,j;
		int arr[][] = new int[n][n];
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				arr[i][j] = Integer.MAX_VALUE/2;
		for(i=0;i<m;i++){
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			r = sc.nextInt();
			arr[x][y] = r;
		}
		floyd(arr);
		q = sc.nextInt();
		StringBuilder br = new StringBuilder(q*10);
		for(i=0;i<q;i++){
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			br.append(dist(arr,x,y)+"\n");
		}
		PRINT(br);
	}

	public static void floyd(int arr[][]){
		int i,j,k;
		int n=arr.length;
		for(i=0;i<n;i++)
			arr[i][i]=0;
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				for(k=0;k<n;k++){
					if(arr[j][k]>arr[j][i]+arr[i][k]){
						arr[j][k] = arr[j][i]+arr[i][k];
					}
				}
			}
		}
	}

	public static int dist(int arr[][], int x, int y){
		if(arr[x][y]>=Integer.MAX_VALUE/2)
			return -1;
		else
			return arr[x][y];
	}
}