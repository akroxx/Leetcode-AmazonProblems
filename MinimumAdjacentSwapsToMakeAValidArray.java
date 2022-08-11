class Solution {
    public int minimumSwaps(int[] nums) {
        int minIdx = -1, maxIdx = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n = nums.length;

        for(int i = 0; i < n; i++){
            //Rightmost largest number
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }

            //Leftmost smallest number
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }
        }

        //if minIdx greater than maxIdx then we minus 1

        return minIdx <= maxIdx ? minIdx + n - 1 - maxIdx : minIdx + n - 2 - maxIdx;

    }
}