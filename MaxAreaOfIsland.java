class Solution {

    int grid[][];
    boolean seen[][];

    public int area(int row, int col){
        if(row < 0 || row >= grid.length
            || col < 0 || col >= grid[0].length
            || seen[row][col] == true || grid[row][col] == 0){
                return 0;
            }
        seen[row][col] = true;  //established that this cols area has been considered for next recursive call

        return (1 + area(row+1, col) + area(row - 1, col)
            +area(row, col+1) + area(row, col - 1));
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int res = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                res = Math.max(res, area(row,col));
            }
        }

        return res;
    }
}