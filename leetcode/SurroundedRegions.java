public class SurroundedRegions {
    boolean[][] free,vis;
    int n,m;
    public void solve(char[][] board) {
        n = board.length;
        if(n==0)
            return;
        m = board[0].length;
        free = new boolean[n][m];// initially all will be surrounded i.e.free = false;
        vis = new boolean[n][m];        
        for(int i=0;i<n;i++){
            vis[i][0]=true;
            vis[i][m-1]=true;
            free[i][0] = board[i][0]=='O';
            free[i][m-1] = board[i][m-1]=='O';
            if(free[i][0]){
                dfs(board,i,1);
            }
            if(free[i][m-1]){
                dfs(board,i,m-2);
            }
        }
        for(int i=0;i<m;i++){
            vis[0][i]=true;
            vis[n-1][i]=true;
            free[0][i] = board[0][i]=='O';
            free[n-1][i] = board[n-1][i]=='O';
            if(free[0][i]){
                dfs(board,1,i);
            }
            if(free[n-1][i]){
                dfs(board,n-2,i);
            }        
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(free[i][j])
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] arr, int i, int j){
        if(i<=0 || j<=0 || i>=n-1 || j>=m-1)
            return ;
        if(vis[i][j] || arr[i][j]=='X')
            return;
        vis[i][j] = true;
        free[i][j] = true;
        //System.out.println(i+"\t"+j);
        dfs(arr,i-1,j);
        dfs(arr,i,j-1);
        dfs(arr,i,j+1);
        dfs(arr,i+1,j);
    }
}

/*
Surrounded Regions
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

*/