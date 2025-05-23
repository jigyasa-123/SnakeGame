import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        int[][] food = {{1,2},{0,1}};
//        try {
//            SnakeGame snakeGame = new SnakeGame(3, 2, food);
//            snakeGame.move("R");
//            snakeGame.move("D");
//            snakeGame.move("R");
//            snakeGame.move("U");
//            snakeGame.move("L");
//            snakeGame.move("U");
//        }catch (IllegalArgumentException e){
//            System.err.println("Game initialization error: " + e.getMessage());
//
//        }catch(SnakeGameException e){
//            System.err.println("Snake Game error: " + e.getMessage())
//        }catch (Exception e){
//            System.err.println("An unexpected error occurred: " + e.getMessage());
//            logger.log(Level.SEVERE, "Unexpected error in main method.", e);
//        }

        // Initializetion issue (height and width not under required condition)
//        try {
//
//            new SnakeGame(0, -1, food);
//        }catch (IllegalArgumentException e){
//            System.err.println("Caught expected error for invalid width: " + e.getMessage());
//        }
         //Hit the boundary and crashes
//            SnakeGame snakeGame = new SnakeGame(3, 2, food);
//            snakeGame.move("R");
//            snakeGame.move("D");
//            snakeGame.move("D");



        //Bite itself
//        food = new int[][]{{1, 1}, {1, 2}};
//        SnakeGame snakeGame = new SnakeGame(3, 2, food);
//        snakeGame.move("R");
//        snakeGame.move("D");
//        snakeGame.move("R");
//        snakeGame.move("L");


        //Invalid Direction input

        //Empty food array

        //Does not fit into the grid
        food = new int[][]{{1, 1}, {1, 2}};
        SnakeGame snakeGame = new SnakeGame(3, 2, food);
        snakeGame.move("R");
        snakeGame.move("D");
        snakeGame.move("R");
        snakeGame.move("L");






    }
}


/*
* Test cases:
* 1. Initialization issue
* 2. Food array is empty
* 3. Boundary collision
* 5. Bite itself
* 6. Invalid Direction
* 7. Happy case
* Termination Condition:
*
* */


/*
* Multithreaded snake game:
* Different thread to run different tasks:
* 1.Game Logic Thread
* 2. Rendering Thread
* 3. Input Listner
*
* Challenges:
* 1. The Snake object, Food object, and the Board (or grid) are shared between the game logic and rendering threads. You must protect access to this shared state.
* Use synchronized methods/blocks or java.util.concurrent locks (e.g., ReentrantLock) to ensure that only one thread modifies the game state at a time, and that the rendering thread gets a consistent snapshot.
*
*2. Inter-Thread Communication:
* Game Logic -> Rendering : Use Object.wait()/notifyAll(), BlockingQueue
* nput -> Game Logic : Use BlockingQueue<Direction> or a volatile
 *
* */