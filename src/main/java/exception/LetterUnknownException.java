package exception;

public class LetterUnknownException extends RuntimeException {
    public LetterUnknownException() {
        super("The command have a letter unknown");
    }
}