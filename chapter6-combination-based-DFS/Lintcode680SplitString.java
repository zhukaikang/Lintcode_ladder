public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        List<String> com = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(s, com, res);
        return res;
    }
    
    private void dfs(String s, List<String> com, List<List<String>> res) {
        if(s.equals("")){
            res.add(new ArrayList<String>(com));
            return;
        }
        for(int i=1;i<=2;i++){
            if(i<=s.length()){
		        com.add(s.substring(0,i));
		        //use s.length()。如果用i+2 when 剩下的s已经没有长度为0或为1，会出错。
		        //此外程序每次i从1开始，如果出现s长度为0，此时会出现越界错误，所以必须判断i小于等于s的长度。
		        dfs(s.substring(i, s.length()), com, res);
		        com.remove(com.size()-1);
        }
        }
    }
}