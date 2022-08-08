class Solution {
    public int minSwaps(int[] data) {        
        int ones = 0;

        //O(n)
        for(int x : data){            
            ones +=x;
        }

        //ones becomes window size
        int currOnes = 0, maxOnes = 0;
        int left = 0, right = 0;

        //O(n)
        while(right < data.length){
            currOnes += data[right++];


            if(left + right > ones)
                currOnes -= data[left++];

            maxOnes = Math.max(maxOnes, currOnes);
        }

        return ones - maxOnes;
    }
}