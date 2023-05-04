package exceptions;

public class InvalidCreatureTypeException extends Exception {
    public InvalidCreatureTypeException() {
        super("Invalid creature type.");
    }
}
