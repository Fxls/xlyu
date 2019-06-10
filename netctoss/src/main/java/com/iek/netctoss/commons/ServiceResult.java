/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */
package com.iek.netctoss.commons;

import java.util.Objects;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-10 15:22
 **/
public class ServiceResult<E> {
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //查询成功
    private boolean success;

    // 提示信息
    private String msg;

    private E data;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ServiceResult() {
        success = true;
        msg = "请求成功！";
    }

    public ServiceResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceResult<?> that = (ServiceResult<?>) o;
        return success == that.success &&
                Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, msg);
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
}
