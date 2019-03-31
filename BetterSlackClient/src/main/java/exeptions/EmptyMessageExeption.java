package exeptions;

public class EmptyMessageExeption extends RuntimeException {
    public EmptyMessageExeption(){
        super("Message cannot be empty!");

    }
}
