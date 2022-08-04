class Solution {
    public int minFlipsMonoIncr(String s) {
        // Create two variable one and flip
        int one =0, flip =0;
        // Check at every instance if 1 or 0
        // Flip is maintained to be the least number of flips required
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i)=='1')
                one++;
            else
                flip++;
            flip = Math.min(one,flip);
        }
        return flip;
    }
}