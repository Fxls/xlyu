/**
 * @Author xlyu
 * @Date 2019/6/4
 * @Description
 */
package com.itek.servlet.day10.servlet;

import com.itek.servlet.day10.module.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: servletDay10
 * @description:
 * @author: xlyu
 * @create: 2019-06-04 10:01
 **/

@WebServlet(name = "ELTestServlet", urlPatterns = "/EL")
public class ELTestServlet extends HttpServlet {
    List<User> list;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session;
        User user1 = new User("name1", "男", 20);
        User user2 = new User("name2", "女", 21);
        User user3 = new User("name3", "男", 22);
        User user4 = new User("name4", "女", 23);
        User user5 = new User("name5", "男", 24);
        list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
    }
}
