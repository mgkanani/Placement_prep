public class MinCostPath{
	int table[][];
	public int minpath(int matrix[][]){
		int m,n;
		m = matrix.length;
		n = matrix[0].length;
		table = new int[m][n];
		int cost = calc_cost(matrix,m-1,n-1);
		return cost;
	}

	int calc_cost(int matrix[][], int m, int n){
		if(m==0 && n==0)
			return matrix[0][0];
		if(table[m][n]!=0){
			return table[m][n];
		}else{
			int min=1;
			min= min<<30;
			if(m-1>=0)
				min = Math.min(calc_cost(matrix,m-1,n),min);
			if(n-1>=0)
				min = Math.min(calc_cost(matrix,m,n-1),min);
			if(m-1>=0 && n-1>=0)
				min = Math.min(calc_cost(matrix,m-1,n-1),min);
			table[m][n] = matrix[m][n] + min;
			return table[m][n];
		}
	}
	public static void main(String args[]){
		MinCostPath obj = new MinCostPath();
		int matrix[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
		int cost = obj.minpath(matrix);
		System.out.println(cost);
	}
}
