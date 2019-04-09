public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if(s == null || p == null)
        {
            return false;
        }
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    
    private boolean isMatchHelper(String s, int sIndex, String p, int pIndex, boolean[][] memo, boolean[][] visited)
    {
        if(pIndex == p.length())
        {
            return sIndex == s.length();
        }
        if(sIndex == s.length())
        {
            return allStar(p, pIndex);
        }
        
        if(visited[sIndex][pIndex])
        {
            return memo[sIndex][pIndex];
        }
        
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;
        
        if(pChar == '*')
        {
            match = isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited) ||
            isMatchHelper(s, sIndex, p, pIndex + 1, memo, visited);
        }
        else{
            match = isMatchHelper(s, sIndex+1, p, pIndex+1, memo, visited) &&
            matchChar(sChar, pChar);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        
        return match;
    }
    
    private boolean matchChar(char s, char p)
    {
        return (s == p || p == '?');
    }
    private boolean allStar(String p, int pIndex)
    {
        for(int i=pIndex;i<p.length();i++)
        {
            if(p.charAt(i)!='*')
            {
                return false;
            }
        }
        return true;
    }
}