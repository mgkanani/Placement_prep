class MinStack {
    int arr[];
    int min[];
    int cap,top;
    public MinStack(){
        top=-1;
        cap=1;
        arr= new int[1];
        min= new int[1];
    }
    public void push(int x) {
        if(top==cap-1){
            int narr[]=new int[2*cap];
            int min_arr[]=new int[2*cap];
            System.arraycopy(arr,0,narr,0,cap);
            System.arraycopy(min,0,min_arr,0,cap);
            cap=2*cap;
            arr=narr;
            min=min_arr;
        }
	if(top>=0){
	        if(min[top]>x)
	            min[top+1]=x;
	        else
	            min[top+1]=min[top];
	}else{
	            min[top+1]=x;
	}
        arr[++top]=x;
    }
    public void pop() {
        if(top>=0){
            top--;
        }
    }
    public int top() {
        if(top>=0)
            return arr[top];
	return 0;
    }
    public int getMin() {
        if(top>=0)
            return min[top];
	return 0;
    }
public static void main(String arg[]){
	MinStack stack= new MinStack();
	stack.push(4);
	System.out.println(stack.getMin());
	stack.push(2);
	System.out.println(stack.getMin());
	stack.push(1);
	System.out.println(stack.getMin());
	stack.push(5);
	stack.pop();
	stack.pop();
	System.out.println(stack.getMin());
}
}

