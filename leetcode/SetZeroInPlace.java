public class SetZeroInPlace {
    public void setZeroes(int[][] matrix) {
        int n=0,m = matrix.length;
        arr=matrix;
        if(m>0)
            n = matrix[0].length;
        int i,j,k;
        boolean row = false,col= false;
        for(j=0;j<n;j++){row = row || matrix[0][j]==0;}
        for(i=0;i<m;i++){col = col || matrix[i][0]==0;}
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(i=0;i<m;i++)
                    matrix[i][j]=0;
            }
        }
        for(i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(j=0;j<n;j++)
                    matrix[i][j]=0;
            }
        }
        if(row){
            for(j=0;j<n;j++)
                matrix[0][j]=0;
        }
        if(col){
            for(i=0;i<m;i++)
            matrix[i][0]=0;
        }
   }
}

/*
Set Matrix Zeroes


Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 

Follow up:

Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/