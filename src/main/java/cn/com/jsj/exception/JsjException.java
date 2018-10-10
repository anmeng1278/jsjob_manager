package cn.com.jsj.exception;


import cn.com.jsj.enums.ResultEnum;

public class JsjException extends RuntimeException {

    private Integer code;

    public JsjException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public JsjException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
