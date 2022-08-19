class Solution {
    public int minimumKeypresses(String s) {
        int res = 0;

        Integer freq[] = new Integer[26];
        Arrays.fill(freq, 0);

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        Arrays.sort(freq, Collections.reverseOrder());

        for(int i = 0; i < freq.length; i++){
            int cost = (i/9) + 1;
            res += cost * freq[i];
        }

        return res;
    }
}