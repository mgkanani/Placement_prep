import java.util.*;

public class EditDist {
	int dp[][];
	String s1,s2;
	public int editdist(String s1, String s2){
		this.s1=s1;
		this.s2=s2;
		int l1,l2;
		l1=s1.length();
		l2=s2.length();
		dp = new int[l1+1][l2+1];
		int i,j;
		for(i=0;i<=l1;i++)
			for(j=0;j<=l2;j++)
				dp[i][j]=-1;
		return cost(l1,l2);
		//return dp[l1][l2];
	}
	public int cost(int x, int y){
		if(x==0)
			return y;
		if(y==0)
			return x;
		if(dp[x][y]!=-1){
		}else if(s1.charAt(x-1)==s2.charAt(y-1)){
			dp[x][y]=cost(x-1,y-1);
		}else{
			int m1,m2;
			m1=Math.min(cost(x-1,y),cost(x,y-1));
			m2=Math.min(m1,cost(x-1,y-1));
			dp[x][y]=1+m2;
		}
		return dp[x][y];
	}

	public static void main(String arg[]){
		EditDist obj = new EditDist();
		/*Scanner in = new Scanner(System.in);
		int T;
		int i=0;
		for(i=0;i<T;i++){
		}*/

		System.out.println(obj.editdist("SUNDAY","SATURDAY"));
	}
}
