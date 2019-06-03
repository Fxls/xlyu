/**
 * @Author xlyu
 * @Date 2019/6/3
 * @Description
 */
package com.itek.servlet.day09.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @program: servletDay09
 * @description:
 * @author: xlyu
 * @create: 2019-06-03 14:53
 **/
public class LoginListener implements HttpSessionListener {
    int onlineCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        onlineCount++;
        System.out.println("在线人数为："+onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        onlineCount--;
        System.out.println("在线人数为："+onlineCount);
    }
}
