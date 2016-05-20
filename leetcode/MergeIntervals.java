/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> list) {
        Collections.sort(list,new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start==i2.start){
                    return i1.end-i2.end;
                }
                return i1.start-i2.start;
            }
        });
        Interval last = null;
        List<Interval> tmp_list = new ArrayList<Interval>();
        for(Interval cur:list){
            if(last!=null && check(last,cur)){
                last.end = Math.max(last.end,cur.end);
                //tmp_list.remove(cur);
            }else{
                tmp_list.add(cur);
                last=cur;
            }
        }
        return tmp_list;
    }
    boolean check(Interval i1, Interval i2){
        if(i2.start<=i1.end)
            return true;
        return false;
    }
}
/*
Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
*/