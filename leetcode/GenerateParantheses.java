/*
Generate Parentheses
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" 

Catalan numbers , Distinct Binary Trees
*/
public class GenerateParantheses {
    ArrayList<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        this.n=n;
        if(n==0)
            return new ArrayList<String>(res);
        generate(0,0,"");
        return res;
    }
    public void generate(int open, int close,String s){
        if(open==n && close==n){
            res.add(s);
        }else{
            if(open<n)
                generate(open+1,close,s+"(");
            if(close<open)
                generate(open,close+1,s+")");
        }
    }
}