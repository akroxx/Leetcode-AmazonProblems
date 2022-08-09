public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();    //Kind of a last seen map, but in terms of 1-index hence
        //storing char, i+1

        int res = 0;

        for(int i = 0, j = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                j = Math.max(j, map.get(c));
            }
            res = Math.max(res, i - j + 1);
            map.put(c, i+1);
        }
        return res;
    }
}