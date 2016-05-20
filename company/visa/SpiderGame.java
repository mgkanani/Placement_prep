/*
spiderman playground.

*/
public class SpiderGame{
    //static int dp[][];
	static int m,n;
	public int calculateMinimumHP(int[][] grid) {
		m=grid.length;
		n= grid[0].length;
        grid[m-1][n-1] = Math.max(1,1 - grid[m-1][n-1]);
        int v1=-1;
        // for last column
        for(int i=m-2;i>=0;i--){
            v1 = grid[i+1][n-1] - grid[i][n-1];
            grid[i][n-1] = Math.max(1,v1);
        }
        //for last row.
        for(int j=n-2;j>=0;j--){
            v1 = grid[m-1][j+1] - grid[m-1][j];
            grid[m-1][j] = Math.max(1,v1);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                v1 = Math.min(grid[i+1][j],grid[i][j+1]) - grid[i][j];
                grid[i][j] = Math.max(1,v1);
            }
        }/*
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                System.out.print(grid[i][j]+" ");
            System.out.println();
        }*/
        return grid[0][0];
    }
}