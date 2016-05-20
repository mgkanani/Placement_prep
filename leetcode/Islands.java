public class Islands {
	int rows[] = {0,0,1,-1};//,-1,1,-1,1};
	int cols[] = {1,-1,0,0};//,-1,1,1,-1};
	int len = rows.length;
    public int numIslands(char[][] arr) {
 	   int cnt=0;
 	   for(int i=0;i<arr.length;i++){
 	   		for(int j=0;j<arr[0].length;j++){
 	   			if(arr[i][j]=='1'){
 	   				cnt++;
 	   				setZero(arr,i,j);
 	   			}
 	   		}
 	   }
 	   return cnt;
    }
	public void setZero(char[][] arr,int i, int j) {
		if(i<0||j<0||i>=arr.length || j>=arr[0].length)
			return;
		arr[i][j]='0';
		int ni=0,nj=0;
		for(int i1=0;i1<len;i1++){
		    ni=i+rows[i1];
		    nj=j+cols[i1];
			if((ni<arr.length && ni>=0) && (nj<arr[0].length && nj>=0) && arr[ni][nj]=='1'){
				setZero(arr,ni,nj);
			}
		}
	}
}

/*
Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

Answer: 1

Example 2:

11000
11000
00100
00011

Answer: 3
*/