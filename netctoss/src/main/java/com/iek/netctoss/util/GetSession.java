/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */
package com.iek.netctoss.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-10 20:18
 **/
public class GetSession {
    public HttpSession getSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return session;
    }
}
