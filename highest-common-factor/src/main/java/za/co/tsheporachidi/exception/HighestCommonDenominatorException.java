package za.co.tsheporachidi.exception;

/**
 * @author Tshepo Rachidi
 * this class is an extension of @{@link RuntimeException} it is used as an application wide Exception for operations not allowed.
 */
public class HighestCommonDenominatorException extends RuntimeException{
    public HighestCommonDenominatorException(){
        super();
    }
    public HighestCommonDenominatorException(String errMessage){
        super(errMessage);
    }
}
