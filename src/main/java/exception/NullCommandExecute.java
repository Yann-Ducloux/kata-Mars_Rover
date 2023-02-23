package exception;

public class NullCommandExecute extends RuntimeException {
    public NullCommandExecute() {
        super("this commands is null");
    }
}