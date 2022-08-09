import java.util.Deque;

class SnakeGame {

    HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
    Deque<Pair<Integer, Integer>> snake;
    int food[][];
    int idxFood;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.snakeMap = HashMap<Pair<Integer, Integer> ,Boolean>();
        this.snakeMap.put(new Pair<Integer, Integer>(0,0), true);   //init

        this.snake = new LinkedList<Pair<Integer, Integer>>();
        this.snake.offerLast(new Pair<Integer, Integer>(0,0));
    }
    
    public int move(String direction) {
        Pair<Integer, Integer> snakeCell = this.snake.peekFirst();
        int newHeadRow = snakeCell.getKey();
        int newHeadColumn = snakeCell.getValue();

        switch(direction){
            case "U" :
                newHeadRow--;
                break;
            case "D" :
                newHeadRow++;
                break;
            case "L" :
                newHeadColumn--;
                break;
            case "R" :
                newHeadColumn++;
                break;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */