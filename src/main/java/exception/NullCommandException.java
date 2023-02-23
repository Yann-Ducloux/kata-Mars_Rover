package exception;

public class NullCommandException extends RuntimeException {
    public NullCommandException() {
        super("this command is null");
    }
}