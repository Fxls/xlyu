package com.itek.spring.springDay04.commons;

/**
 * package com.itek.spring.springDay04.commons
 *
 * @author xlYu
 * @date 2019/6/29
 */
public enum ResultEnum {
    /**
     * 登录成功
     */
    SUCCESS(0, "登录成功！"),
    /**
     * 登录失败
     */
    FAILED(1, "登录失败！");

    /**
     * 用户错误信息和错误码
     */
    private Integer resultCode;
    private String message;

    ResultEnum(Integer resultCode, String message) {
        this.message = message;
        this.resultCode = resultCode;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultEnum{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }


}
