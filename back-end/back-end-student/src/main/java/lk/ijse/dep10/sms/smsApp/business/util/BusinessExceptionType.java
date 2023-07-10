package lk.ijse.dep10.sms.smsApp.business.util;

public enum BusinessExceptionType {
    BUSINESS(1000, "Business Exception"),
    RECORD_NOT_FOUND(1001, "Record No Found"),;
    private int code;
    private String message;

    BusinessExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
