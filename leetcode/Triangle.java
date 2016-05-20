import java.util.*;

public class Triangle {
    int arr[];
    public int minimumTotal(List<List<Integer>> triangle) {
         arr = new int[triangle.size()];
         int temp[] = new int[triangle.size()];
         int temp1[] = new int[triangle.size()];
         List<Integer> list;
         int i=0,j=0;
         int min=1;
         int t_min=0;
         while(!triangle.isEmpty()){
         	min<<=30;
             list = triangle.remove(0);
             i=0;
	     //System.out.println(list);
             while(!list.isEmpty()){
                 arr[i]=(Integer)list.remove(0);
                 i++;
             }
             for(j=0;j<i;j++){
                 if(j==0){
                     //if(j+1<i-1)
                     //   temp1[j] = arr[j] + Math.min(temp[j],temp[j+1]);
                    //else 
                        temp1[j] = arr[j] + temp[j];
                 }else if(j==i-1){
                    temp1[j] = arr[j] + temp[j-1];
                 }else{
                    t_min= Math.min(temp[j-1],temp[j]);
		    //if(j+1<i-1)
	            //        t_min = Math.min(t_min,temp[j+1]);
                    temp1[j] = arr[j] + t_min;
                 }
                 if(min>temp1[j])
                    min = temp1[j];
		//System.out.print(temp1[j]+"\t");
             }
             arr = temp;
             temp = temp1;
             temp1 = arr;
         }
	 //System.out.print(min);
         return min;
    }

    public static void main(String arg[]){
	Triangle tri = new Triangle();
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	List<Integer> l = new ArrayList<Integer>();
	l.add(-1);
	list.add(l);
	l = new ArrayList<Integer>();
	l.add(3);
	l.add(2);
	list.add(l);
	l = new ArrayList<Integer>();
	l.add(-3);
	l.add(1);
	l.add(-1);
	list.add(l);
	tri.minimumTotal(list);
    }
}
