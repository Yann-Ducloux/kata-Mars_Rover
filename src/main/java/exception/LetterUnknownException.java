package exception;

public class LetterUnknownException extends RuntimeException {
    public LetterUnknownException() {
        super("letter unknown");
    }
}