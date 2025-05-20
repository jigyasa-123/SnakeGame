public class SnakeGameException extends  RuntimeException{
    public SnakeGameException(String message){
        super(message);
    }

    public SnakeGameException(String message,Throwable cause){
        super(message,cause);
    }

}
