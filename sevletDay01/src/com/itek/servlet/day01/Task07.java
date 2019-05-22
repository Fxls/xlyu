/**
 * @Author xlyu
 * @Date 2019/5/22
 * @Description
 */
package com.itek.servlet.day01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @program: sevletDay01
 * @description: servlet显示当前时间
 * @author: xlyu
 * @create: 2019-05-22 14:30
 **/
public class Task07 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重写service方法显示网页时间，两种方法实现

        // TODO 1 html传输
//        File file = new File("E:/soft/git/xlyu/sevletDay01/src/com/itek/servlet/day01/task07.html");
//        FileInputStream fis = new FileInputStream(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//        String read = null;
//        String str = "";
//        while ((read = br.readLine()) != null) {
//            str += read;
//        }

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
//        System.out.println(str);
        pw.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta  charset=\"UTF-8\">\n" +
                "    <title>时间显示</title>\n" +
                "    <style>\n" +
                "        div {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        input{\n" +
                "            text-align: center;\n" +
                "            font-size: 40px;\n" +
                "            border: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <script>\n" +
                "        function showTime() {\n" +
                "            var time = new Date();\n" +
                "            var input=document.getElementById(\"showContent\");\n" +
                "            input.value=time.toLocaleTimeString();\n" +
                "        }\n" +
                "        setInterval(showTime,10);\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body onload=\"showTime()\">\n" +
                "<div>\n" +
                "    <h1>时间显示</h1>\n" +
                "    <input type=\"text\" id=\"showContent\">\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");



        // TODO 2 java传输




    }
}
