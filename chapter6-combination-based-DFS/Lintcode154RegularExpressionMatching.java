package chaper6;

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if(s == null || p == null)
        {
            return false;
        }
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        
        return helper(s, 0, p, 0, memo, visited);
    }
    
    private boolean helper(String s, int sIndex, String p, int pIndex, boolean[][] memo, boolean[][] visited)
    {
        if(pIndex == p.length())
        {
            return sIndex == s.length();
        }
        
        if(sIndex == s.length())
        {
            return isEmpty(p, pIndex);
        }
        
        if(visited[sIndex][pIndex])
        {
            return memo[sIndex][pIndex];
        }
        
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;
        if(pIndex+1<p.length() && p.charAt(pIndex+1) == '*')
        {
            match = helper(s, sIndex, p, pIndex+2, memo, visited) ||
            matchChar(sChar, pChar) && helper(s, sIndex+1, p, pIndex, memo, visited);
        }
        else{
            match = matchChar(sChar, pChar) && helper(s, sIndex+1, p, pIndex+1, memo, visited);
        }
        
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
        
    }
    
    private boolean matchChar(char s, char p){
        if(s==p || p == '.')
        {
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isEmpty(String p, int pIndex)
    {
        for(int i = pIndex;i<p.length();i+=2)
        {
            if(i+1>=p.length()||p.charAt(i+1)!='*')
            {
                return false;
            }
        }
        return true;
    }
}
