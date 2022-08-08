class Solution {
    public long subArrayRanges(int[] A) {
        long res = 0;
        int n = A.length, j , k;


        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && A[stack.peek()] > (i == n ? Integer.MIN_VALUE : A[i])){
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res -= (long) A[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = 0; i <= n; i++){
            while( !stack.isEmpty() && A[stack.peek()] < (i == n ? Integer.MAX_VALUE : A[i])){
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res += (long)A[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }

        return res;
    }
}