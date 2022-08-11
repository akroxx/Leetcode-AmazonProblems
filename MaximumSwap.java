class Solution {
    public int maximumSwap(int num) {
        int mxIdx = -1, mxDigit = -1, left = -1, right = -1;
        int arr[] = new int[String.valueOf(num).length()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = String.valueOf(num).charAt(i) - '0';
        }        

        int n = arr.length;

        for(int i = n - 1; i >= 0; i--){
            if(arr[i] > mxDigit){
                mxDigit = arr[i];
                mxIdx = i;
                continue;
            }

            if(arr[i] < mxDigit){
                left = i;
                right = mxIdx;
            }
        }
        
        if(left == -1) return num;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        int res = 0;
        for(int i = 0; i < arr.length; i++){
            res = (10*res) + arr[i];
        }

        return res;
    }
}