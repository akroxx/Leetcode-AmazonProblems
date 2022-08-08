class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        
        String s = "123456789";
        //10^9 = 1000000000
        
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        
        for(int length = lowLen; length < highLen + 1; length++){   //variating window length/size as per range <100, 40000> => lowLen -> 3, highLen -> 5
            for(int start = 0; start < 10 - length; start++){   //all window possibilities considered
                int num = Integer.parseInt(s.substring(start, start+length));
                if(num >= low && num <= high)   //both range limits inclusive[]
                    res.add(num);
            }
        }
        
        return res;
        
    }
}