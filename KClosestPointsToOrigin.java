class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int res[][] = new int[k][2];

        int distance[] = new int[points.length];

        for(int i = 0; i < points.length; i++){
            distance[i] = helper(points[i]);
        }

        Arrays.sort(distance);

        int closest = distance[k-1];

        int ptr = 0;

        for(int i = 0; i < points.length; i++){
            if(helper(points[i]) <= closest){
                res[ptr++] = points[i];
            }
        }

        return res;
    }

    public int helper(int co[]){
        return (co[0] * co[0])+ (co[1] * co[1]);
    }

}