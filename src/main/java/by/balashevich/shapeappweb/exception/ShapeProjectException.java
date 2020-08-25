package by.balashevich.shapeappweb.exception;

public class ShapeProjectException extends Exception{
    public ShapeProjectException() {
        super();
    }

    public ShapeProjectException(String message) {
        super(message);
    }

    public ShapeProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeProjectException(Throwable cause) {
        super(cause);
    }
}
