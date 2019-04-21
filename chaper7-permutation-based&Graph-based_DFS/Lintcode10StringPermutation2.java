public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(str == null)
        {
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String per = new String();
        //StringBuilder sb = new StringBuilder(per);
        //Arrays.sort(str);
        dfs(chars, new boolean[str.length()], per, res);
        return res;
    }
    
    private void dfs(char[] chars, boolean[] visited, String per, List<String> res)
    {
        if(chars.length==per.length())
        {
            res.add(new String(per));
            return;
        }
        for(int i=0;i<chars.length;i++)
        {
            if(visited[i])
            {
                continue;
            }
            if(i>0 && chars[i] == chars[i-1] && !visited[i-1])
            {
                continue;
            }
            per += chars[i];
            visited[i] = true;
            dfs(chars, visited, per, res);
            visited[i] = false;
            per = per.substring(0, per.length()-1);
            //per = sb.toString();
        }
    }
}