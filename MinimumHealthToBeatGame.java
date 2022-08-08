class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long res = 1;   //should be greater than 0 at all times

        int maxDamage = Integer.MIN_VALUE;

        for(int d : damage){
            res += d;
            maxDamage = Math.max(maxDamage, d);
        }

        res -= Math.min(maxDamage, armor);
        
        return res;
    }
}