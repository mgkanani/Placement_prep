import java.util.*;

public class AllPair {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int matrix[][] = new int[n][n];
		int i,j,k,x,y;
		int e = sc.nextInt();
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				matrix[i][j]=Integer.MAX_VALUE/2;
			}
		}
		for(i=0;i<n;i++)
			matrix[i][i]=0;
		for(i=0; i<e; i++){
			x = sc.nextInt();
			y = sc.nextInt();
			matrix[x][y] = sc.nextInt();
			matrix[y][x] = matrix[x][y];
		}
		for(k=0;k<n;k++){
			for(i=0;i<n;i++){
				for(j=0;j<n;j++){
					matrix[i][j] = Math.min(matrix[i][k]+matrix[k][j],matrix[i][j]);
				}
			}
		}
		int queries = sc.nextInt();
		int src,dest,lst=-1;
		long sum = 0;
		for(i=0;i<queries;i++){
			src = sc.nextInt();
			dest = sc.nextInt();
			if(lst!=-1){
				sum+=matrix[lst][src];
			}
			lst = dest;
			sum+=matrix[src][dest];
		}
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(sum);
	}	
}