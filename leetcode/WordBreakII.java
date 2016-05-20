/*
Word Break II

 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Subscribe to see which companies asked this question

*/

public class WordBreakII {
    int Len;
    String _str;
    public List<String> wordBreak(String s, Set<String> dict) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int len = s.length();
        Len=len;
        _str=s;
        String tmp=null;
        ArrayList<Integer> set =null;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len+1;j++){
                tmp = s.substring(i,j);
                if(dict.contains(tmp)){
                    if(!map.containsKey(j)){
                        set = new ArrayList<Integer>();
                        set.add(i);
                        map.put(j,set);
                        
                    }else{
                        set.add(i);
                    }
                }
            }
        }
        return process(map,len);
    }
    public List<String> process(HashMap<Integer, ArrayList<Integer>> map, int len){
        if(len==0){
            List<String> list = new ArrayList<String>();
            list.add("");
            return list;
        }else if(!map.containsKey(len)){
            return null;
        }else{
            ArrayList<Integer> list = map.get(len);
            List<String> result = new ArrayList<String>();
            for(int i: list){
                List<String> strs = process(map,i);
                if(strs!=null){
                    for(String s: strs){
                        if(s.equals(""))
                            result.add(_str.substring(i,len));
                        else
                            result.add(s+" "+_str.substring(i,len));
                    }
                }
            }
            return result;
        }
    }
}