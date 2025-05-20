import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SnakeGame {
    HashMap<Pair<Integer, Integer>, Boolean> snakeMap;
    Deque<Pair<Integer,Integer>> snake;
    int height;
    int width;
    int[][] food;
    int foodIndex;
    private static final Logger logger = Logger.getLogger(SnakeGame.class.getName());
    public SnakeGame(int width, int height, int[][] food) {
        if(width <=0 || height<=0){
            logger.log(Level.SEVERE, "Invalid game dimensions: width=" + width + ", height=" + height);
            throw new IllegalArgumentException("Width and height must be positive.");
        }

        this.width = width;
        this.height = height;
        this.food = food;
        this.snakeMap = new HashMap<Pair<Integer,Integer>,Boolean>();
        this.snakeMap.put(new Pair<>(0,0),true);
        this.snake = new LinkedList<Pair<Integer,Integer>>();
        this.snake.offerLast(new Pair<>(0,0));
        this.foodIndex = 0;
        logger.log(Level.INFO, "SnakeGame initialized with width=" + width + ", height=" + height + ", food items=" + food.length);

    }

    public int move(String direction) {
        Pair<Integer,Integer> currHead = snake.peekFirst();
        int newHeadRow = currHead.getKey();
        int newHeadCol = currHead.getValue();
        try {
            switch (direction) {
                case "U":
                    --newHeadRow;
                    break;
                case "D":
                    ++newHeadRow;
                    break;
                case "L":
                    --newHeadCol;
                    break;
                case "R":
                    ++newHeadCol;
                    break;
                default:
                    logger.log(Level.WARNING, "Invalid move direction: " + direction + ". Returning -1.");
                    throw new IllegalArgumentException();

            }
        }catch (Exception e){
        logger.log(Level.SEVERE, "Error while calculating new head position for direction: " + direction, e);
        throw new SnakeGameException("Error during move calculation.", e);
    }

        Pair<Integer,Integer> newHead = new Pair<>(newHeadRow,newHeadCol);
        Pair<Integer,Integer> currTail = snake.peekLast();
        //check boundary conditions
       // System.out.println("Directions:"+direction+" "+newHeadRow+" "+newHeadCol+" "+currTail.getKey()+" "+currTail.getValue()+" "+snakeMap.containsKey(newHead));
       // print(snakeMap);
        //System.out.println("get:"+snakeMap.containsKey(newHead));
        Boolean crossesBoundary1 = newHeadRow < 0 || newHeadRow >= height;
        Boolean crossesBoundary2 = newHeadCol < 0 || newHeadCol >= width;
        boolean biteItself = this.snakeMap.containsKey(newHead) && !(Objects.equals(newHead.getKey(), currTail.getKey()) && Objects.equals(newHead.getValue(), currTail.getValue()));
        if (crossesBoundary1 || crossesBoundary2) {
            logger.log(Level.INFO, "Snake crashed into boundary at (" + newHeadRow + "," + newHeadCol + ")");
            return -1;
        }
        if (biteItself) {
            logger.log(Level.INFO, "Snake bit itself at (" + newHeadRow + "," + newHeadCol + ")");
            return -1;
        }


        // check if food is present

        if((foodIndex < food.length) &&
                (food[foodIndex][0] == newHeadRow) &&
                (food[foodIndex][1] == newHeadCol))
        {
            logger.info("Food found");
            ++foodIndex;
        }else{
            snake.pollLast();
            snakeMap.remove(currTail);
        }

        snake.offerFirst(newHead);

        snakeMap.put(newHead,true);
        System.out.println(snake.size() -1);
        return snake.size() -1;

    }
    void print(HashMap<Pair<Integer,Integer>,Boolean> snakeMap){
        System.out.println("Print map");

        for(Pair<Integer,Integer> p : snakeMap.keySet()){
            System.out.println(p.getKey()+" "+p.getValue());
        }

    }
}
