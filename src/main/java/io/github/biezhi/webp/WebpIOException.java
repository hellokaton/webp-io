package io.github.biezhi.webp;

/**
 * Webp runtime exception
 *
 * @author biezhi
 * @date 2017/10/2
 */
public class WebpIOException extends RuntimeException {

    public WebpIOException(String message) {
        super(message);
    }

    public WebpIOException(Throwable cause) {
        super(cause);
    }
}
