import java.util.*;

public class MatrixMult {
	int dp[][];
	int arr[];
	public int cost(int arr[]){
		this.arr=arr;
		dp = new int[arr.length+1][arr.length+1];
		return mult(1,arr.length);
	}
	public int mult(int i, int j){
		if(i>=j-1){
			return 0;
		}else if(i+2==j){
			return arr[i-1]*arr[i]*arr[j-1];
		}else if(dp[i][j]!=0){
			return dp[i][j];
		}else{
			int min=1,k,temp;
			min<<=30;
			for(k=i+1;k<j;k++){
				temp = mult(i,k) + mult(k,j) + arr[i-1]*arr[k-1]*arr[j-1];
				//System.out.println(temp);
				if(min>temp)
					min=temp;
			}
			dp[i][j]=min;
			return min;
		}
	}
	public static void main(String arg[]){
		MatrixMult obj = new MatrixMult();
		/*
		Scanner in = new Scanner(System.in);
		int T;
		int i=0;
		for(i=0;i<T;i++){
		}
		*/
		int arr[] = {10, 20,30};
		System.out.println(obj.cost(arr));
	}
}
