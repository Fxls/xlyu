/**
 * @Author xlyu
 * @Date 2019/6/14
 * @Description
 */
package com.itek.ajax.service;

import com.itek.ajax.module.Province;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: ajax
 * @description:
 * @author: xlyu
 * @create: 2019-06-14 18:44
 **/
@WebServlet(name = "AjaxTest", urlPatterns = "/test")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("************");
        Province province = new Province(1,"1","1");
        JSONObject jsonObject = JSONObject.fromObject(province);
        resp.getWriter().write(jsonObject.toString());
    }
}
