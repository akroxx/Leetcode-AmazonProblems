class Solution {
    public int minimumOperations(int[] nums) {
        int res = 0;

        // int subtract = findSmallest(nums);

        while(totalSum(nums) != 0){
            int subtract = findSmallest(nums);
            for(int i = 0; i < nums.length; i++){
                if(nums[i] >  0 && nums[i] != 0){
                    nums[i] -= subtract;
                }
            }
            res++;
        }

        return res;
    }

    public int findSmallest(int nums[]){
        int s = Integer.MAX_VALUE;
        for(int x : nums){
            if(x < s && x != 0){
                s = x;
            }
        }
        return s;
    }

    public int totalSum(int nums[]){
        int sum = 0;
        for(int x : nums){
            sum += x;
        }

        return sum;
    }
}