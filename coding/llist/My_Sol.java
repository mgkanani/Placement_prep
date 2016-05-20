import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class My_Sol {
    public List<Interval> insert(List<Interval> list1, Interval newInterval) {
        if(list1.isEmpty()){
            list1.add(newInterval);
	    return list1;
        }
	List <Interval> list = new CopyOnWriteArrayList<Interval>();
        for(Interval inter : list1)
	    list.add(inter);
        boolean remove=false;
        int i=0;
        Interval last=list.get(0);
        for(Interval iter : list){
            if(remove){
                if(last.start <= iter.start && last.end >= iter.end){
                    list.remove(iter);
                }else if(last.start <= iter.start && last.end >= iter.start){
                    last.start = Math.min(last.start,iter.start);
                    last.end = Math.max(last.end,iter.end);
                    list.remove(iter);
                }else if(last.end<iter.start){
                    break;
                }
            }else{
                if(iter.start == newInterval.start && iter.end==newInterval.end){
                    break;
                }else if(iter.start<=newInterval.start && iter.end>=newInterval.start){
                    iter.start = Math.min(iter.start,newInterval.start);
                    iter.end = Math.max(iter.end,newInterval.end);
                    remove = true;
                    last = iter;
                }else if(iter.start<=newInterval.end && iter.end>=newInterval.end){
                    iter.start = Math.min(iter.start,newInterval.start);
                    iter.end = Math.max(iter.end,newInterval.end);
                    break;
                }else if(last.end < newInterval.start && iter.start>newInterval.end){
                    list.add(i,newInterval);
                    break;
                }
                last = iter;
            }
            i++;
	}
	if(last.end < newInterval.start){
		list.add(i,newInterval);
        }
	return list;
    }

    public static void main(String args[]){
    	My_Sol sol = new My_Sol();
	List <Interval> list = new ArrayList<Interval>();
	Interval i = new Interval(1,5);
	list.add(i);
	i = new Interval(6,8);
//	list.add(i);
//	i = new Interval(5,6);
	list = sol.insert(list,i);
	for(Interval inter : list)
		System.out.println("["+inter.start+","+inter.end+"]");
    }

}

 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

