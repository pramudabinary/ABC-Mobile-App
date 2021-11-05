package lk.abc.spring.exception;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/23/21
 */
public class NotFoundException  extends RuntimeException {
    public NotFoundException(String message){super(message);}
}
