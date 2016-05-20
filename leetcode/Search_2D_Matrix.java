public class Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0)
            return false;
        int n = matrix[0].length;
        int i=0,j=n-1;
        while(i>=0 && i<m && j>=0 && j<n){
            if(target==matrix[i][j])
                return true;
            else if(target>matrix[i][j]){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
