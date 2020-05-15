package myexception.demo2;

/**
 * @Author: melody
 * @Date: 2020-05-15
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught " + e);
        }
    }
}
