package chapter7;

import java.util.*;
public class LintCode121WordLadder2 {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        dict.add(start);
        dict.add(end);
        
        bfs(map, distance, end, start, dict);
        List<String> path = new ArrayList<>();
        dfs(res, path, start, end, distance, map);
        
        return res;
    }
    
    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for(String s: dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while(!q.isEmpty()) {
            String crt = q.poll();
            List<String> nextList = expand(crt, dict);
            for (String next:nextList) {
                map.get(next).add(crt);
                if(!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }
    
    private void dfs(List<List<String>> res, List<String> path, String start, String end, Map<String, Integer> distance, Map<String, List<String>> map) {
        path.add(start);
        if(start.equals(end)) {
            res.add(new ArrayList<String>(path));
            //return;
        }
        else{
            for(String next : map.get(start)) {
                if(distance.containsKey(next) && distance.get(start) == distance.get(next) + 1) {
                    dfs(res, path, next, end, distance, map);
                }
            }
        }
        path.remove(path.size()-1);
    }
    
    private List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<>();
        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
    
    public static void main(String[] args) {
    	LintCode121WordLadder2 a = new LintCode121WordLadder2();
    	Set<String> b = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
    	System.out.println(a.findLadders("hit", "cog", b));
    }
}
