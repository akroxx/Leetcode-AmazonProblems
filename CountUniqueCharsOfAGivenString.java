class Solution {
    public int uniqueLetterString(String s) {
        int result = 0;

        int[][] index = new int[26][2];

        for(int i =0; i < 26; i++){
            index[i] = new int[]{-1,-1};
        }

        int n = s.length();
        for(int i =0; i < n; i++){
            int[] prevIndex = index[s.charAt(i) - 'A'];
        }
    }
}