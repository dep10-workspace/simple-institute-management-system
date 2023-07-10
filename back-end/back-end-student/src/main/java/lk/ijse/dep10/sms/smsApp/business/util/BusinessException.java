package lk.ijse.dep10.sms.smsApp.business.util;

public class BusinessException extends RuntimeException {
    private BusinessExceptionType type;
    private String message;

    public BusinessExceptionType getType() {
        return type;
    }

    public BusinessException(BusinessExceptionType type) {
        this(type, type.getMessage());
    }
    public BusinessException(String message) {
        this(BusinessExceptionType.BUSINESS, message);
    }
    public BusinessException(Throwable cause) {
        this(BusinessExceptionType.BUSINESS,cause);
    }

    public BusinessException(BusinessExceptionType type,String message) {
        super("code:"+type.getCode()+","+message);
        this.type = type;

    }

    public BusinessException(BusinessExceptionType type,Throwable cause) {
        this(type, type.getMessage(), cause);
        this.type=type;
    }

    public BusinessException(BusinessExceptionType type, String message, Throwable cause) {
        super("code:"+type.getCode()+","+message+"cause: ",cause);
    }
}
