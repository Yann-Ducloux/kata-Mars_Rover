package exception;

public class NullCommandExecute extends RuntimeException {
    public NullCommandExecute() {
        super("this command is null");
    }
}