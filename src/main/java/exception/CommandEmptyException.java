package exception;

public class CommandEmptyException extends RuntimeException {
    public CommandEmptyException() {
        super("The Command is empty");
    }
}