/**
 * @Author xlyu
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.springDay04.commons;

import java.util.Objects;

/**
 * @program: springDay04
 * @description: 登录校验的结果集
 * @author: xlYu
 * @create: 2019-06-29 14:08
 **/
public class CheckResult<E> {

    public CheckResult() {
        setCheckResult(ResultEnum.SUCCESS);
    }

    public CheckResult(Integer resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public void setCheckResult(ResultEnum result) {
        this.resultCode = result.getResultCode();
        this.message = result.getMessage();

    }

    private Integer resultCode;
    private String message;
    private E data;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheckResult<?> that = (CheckResult<?>) o;
        return Objects.equals(resultCode, that.resultCode) &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCode, message, data);
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
