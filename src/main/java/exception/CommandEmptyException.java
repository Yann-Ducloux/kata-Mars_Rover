package exception;

public class CommandEmptyException extends RuntimeException {
    public CommandEmptyException() {
        super("The command is empty");
    }
}