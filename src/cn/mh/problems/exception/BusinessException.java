package cn.mh.problems.exception;

/**
 * 业务异常
 *
 * @author komorebi
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException() {
    }

}