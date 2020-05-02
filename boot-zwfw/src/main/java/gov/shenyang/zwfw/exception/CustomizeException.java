package gov.shenyang.zwfw.exception;

/**
 * ClassName:CustomizeException
 * Package:life.majiang.community.exception
 * Description:
 *
 * @Date:2019/12/26 下午 5:59
 * @Author:gaochenyu2012@126.com
 */
public class CustomizeException extends RuntimeException {

    private Integer code;
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
