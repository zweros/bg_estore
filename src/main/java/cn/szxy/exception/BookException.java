package cn.szxy.exception;

/**
 * @Auther:wzer
 * @Date:2019/5/29
 * @Description:cn.szxy.exception
 * @Version:1.0
 *
 * 图书异常类
 **/
public class BookException extends Exception {

    public BookException() {
        super();
    }

    public BookException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
