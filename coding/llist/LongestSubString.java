/*
Reverse the string and use LCS from original string and reversed string to find longest SubString Which is palindrome.
*/

public class LongestSubString {
    public String longestPalindrome(String s) {
        if(s==null)
            return s;
        else if(s.length()==1)
            return s;
        else{
                int i ,j,max=0;
                int n = s.length();
                String ret=s;
                for(i=0;i<n;i++){
                    for(j=n;j>0 && i<j;j--){
                        if(this.isPalin(s.substring(i,j)) && max<(j-i)){
                            ret = s.substring(i,j);
                            max = ret.length();
                        }
                    }
		}
		return ret;
        }
    }
    
    boolean isPalin(String s){
	//System.out.println(s);
        if(s==null)
            return true;
        else if(s.length()==1)
            return true;
        else{
            int n = s.length();
            for(int i=0;i<=n/2;i++){
                if(s.charAt(i)!=s.charAt(n-1-i))
                    return false;
            }
            return true;
        }
    }

public static void main(String arg[]){
	LongestSubString str = new LongestSubString();
	String ret = str.longestPalindrome("lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc");
	System.out.println(ret);

}
}
