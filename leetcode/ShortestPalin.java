public class ShortestPalin {
    String str;
    public String shortestPalindrome(String s) {
        if(s==null||s.length()<=1)
            return s;
        int len = s.length();
        str=s;
        if(checkPalin(-1,len)==0)
            return s;
        Queue<Integer> list = new LinkedList<Integer>();
        char c = s.charAt(0);
        int i=0;
        char arr[] = new char[26];
        arr[c-'a']++;
        for(i=len-1;i>0;i--){
            if(c==s.charAt(i))
                list.add(i);
            arr[s.charAt(i)-'a']++;
        }
        int top=len;
        HashSet<Integer> set = new HashSet<Integer>(list);
        int cnt=0;
        for(i=0;i<26;i++){
            if(arr[i]==1)
                cnt++;
            if(arr[i]==1 && top > s.indexOf('a'+i)){
               //System.out.println(('a'+i)+"\t"+s.indexOf('a'+i));
               top = s.indexOf('a'+i);
               //cnt++;
               //break;
            }
        }
        if(cnt<2)
            top=len;
        //System.out.println(top);
        StringBuilder br = new StringBuilder(2*len);
        while(!list.isEmpty()){
            int end = list.remove();
            if(end<top){
                int k = checkPalin(0,end);
                if(k==0){
                    return build(end,br,len);
                }
            }
        }
        return build(0,br,len);
    }
    public int checkPalin(int st, int end){
        int i=st+1,j=end-1;
        while(i<j && str.charAt(i)==str.charAt(j)){
            i++;
            j--;
        }
        if(i==j || i>j)
            return 0;
        else{
            return -1;
        }
    }
    public String build(int end,StringBuilder br,int len){
        br.append(str.substring(end+1,len));
        br.reverse();
        //System.out.println(br);
        br.append(str.substring(0,end+1));
        //System.out.println(br);
        br.append(str.substring(end+1,len));
        return br.toString();
    }
}


/*
Shortest Palindrome
Total Accepted: 12541 Total Submissions: 70761 Difficulty: Hard

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/