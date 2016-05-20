#include<stdio.h>
/*
void spiral(int a[][],int m, int n){
	int st_row=0,end_row=m,st_col=0,end_col=n,i=0;
	for(; st_row<=(m-1)/2,st_col<=(n-1)/2; st_row++,st_col++){
		for(i=st_row; i<=end_col; i++)
			printf("%d\t",a[st_row][i]);
		printf("\n");
		for(i=st_row+1; i<=end_row; i++)
			printf("%d\t",a[i][end_col]);
		printf("\n");
		for(i=end_col-1; i>=st_col; i--)
			printf("%d\t",a[end_row][i]);
		printf("\n");
		for(i=end_row-1; i>st_row; i--)
			printf("%d\t",a[i][st_col]);
		end_row--;
		end_col--;
	}
}
*/

int main(){
	int i=0,n=0,j=0,m=0;
	scanf("%d %d",&m,&n);
	int a[m][n];
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			a[i][j]=i*10+j;

	//spiral(a,m,n);
        int st_row=0,end_row=m-1,st_col=0,end_col=n-1;
        for(; st_row<=(m-1)/2,st_col<=(n-1)/2; st_row++,st_col++){
                for(i=st_row; i<=end_col; i++)
                        printf("%d\n",a[st_row][i]);
                //printf("\n");
                for(i=st_row+1; i<=end_row; i++)
                        printf("%d\n",a[i][end_col]);
                //printf("\n");
                for(i=end_col-1; i>=st_col; i--)
                        printf("%d\n",a[end_row][i]);
                //printf("\n");
                for(i=end_row-1; i>st_row; i--)
                        printf("%d\n",a[i][st_col]);
                end_row--;
                end_col--;
        }

	return 0;
}
