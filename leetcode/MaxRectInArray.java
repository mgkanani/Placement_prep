public class MaxRectInArray {
    public int maximalRectangle(char[][] arr) {
        int m,n;
        m = arr.length;
        if(m==0)
            return 0;
        n = arr[0].length;
        int i,j,k,cnt=0;
        int hori[][] = new int[m][n];
        for(i=m-1;i>=0;i--){
            for(j=0;j<n;j++){
                if(arr[i][j]=='1'){
                    k=i-1;
                    cnt=1;
                    while(k>=0 && arr[k][j]=='1'){cnt++;k--;}
                    hori[i][j] = cnt;
                }else{
                    hori[i][j] = 0;
                }
            }
        }
        int max=0,temp;
        System.out.println(hori[0][0]);
        for(i=0;i<m;i++){
            max = Math.max(maxRect(hori[i]),max);
        }
        return max;
   }
   public int maxRect(int []arr){
        if(arr.length==0)
            return 0;
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int temp=0;
        int i=0;
        int max=0;
        while(i<n){
            if(st.isEmpty() || arr[st.peek()]<=arr[i]){
                st.push(i);
                i++;
            }else{
                temp = st.pop();
                int w = i - (st.isEmpty()?0:(st.peek()+1));
                int area = w * arr[temp];
                if(area>max)
                    max=area;
            }
        }
        while(!st.isEmpty()){
            temp = st.pop();
            int w = i - (st.isEmpty()?0:(st.peek()+1));
            int area = w * arr[temp];
            if(area>max)
                max=area;
        }
        return max;
   }
}

/*
Maximal Rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area. 


This problem can be converted to the "Largest Rectangle in Histogram" problem. 

*/