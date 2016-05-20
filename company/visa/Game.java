class Pair{
	int minSoFar;
	int cur;
	Pair(int m, int c){
		minSoFar=m;
		cur = c;
	}
}
public class Game{
	static Pair dp[][];
	static int m,n;
	public int calculateMinimumHP(int[][] grid) {
		m=grid.length;
		n= grid[0].length;
        dp = new Pair[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		dp[i][j] = new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE);
        	}
        }

        calc(grid,m-1,n-1);

        System.out.println(min[0]);
        return min[0];
    }

    public static Pair calc(int[][] grid, int x, int y){
    	if(x<0 || y<n){
    		return null;
    	}else if(x==0 && y==0){
    		dp[0][0].cur = grid[0][0];
    		dp[0][0].minSoFar

    		return arr[x][y];
    	}else if(dp[x][y]!=Integer.MIN_VALUE){
    		return dp[x][y];
    	}else{
    		int v1=Integer.MAX_VALUE,v2=Integer.MAX_VALUE;
    		v1 = calc(arr,x+1,y,temp_min1);
    		//temp_min[0] = Math.min(temp_min[0],arr[x][y]);
    		v2 = calc(arr,x,y+1,temp_min2);
    		//temp_min[0] = Math.min(temp_min[0],arr[x][y]);
    		dp[x][y] = arr[x][y] + Math.max(v1,v2);
    		return dp[x][y];
    	}
    }
}