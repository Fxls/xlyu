/**
 * @Author xlyu
 * @Date 2019/6/13
 * @Description
 */
package com.itek.ajax.servlet;

import com.itek.ajax.module.Area;
import com.itek.ajax.module.City;
import com.itek.ajax.module.Province;
import com.itek.ajax.service.AreaService;
import com.itek.ajax.service.AreaServiceImplent;
import com.itek.ajax.service.CityService;
import com.itek.ajax.service.CityServiceImplent;
import com.itek.ajax.service.ProvinceService;
import com.itek.ajax.service.ProvinceServiceImplment;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: ajax
 * @description:
 * @author: xlyu
 * @create: 2019-06-13 20:05
 **/
@WebServlet(name = "City", urlPatterns = "*.city")
public class CityServlet extends HttpServlet {
    private ProvinceService pro = new ProvinceServiceImplment();
    private CityService city = new CityServiceImplent();
    private AreaService area = new AreaServiceImplent();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        switch (uri) {
            case "/ajax/go.city":
                req.getRequestDispatcher("/WEB-INF/jsp/city.jsp").forward(req, resp);
            case "/ajax/pro.city":
                List<Province> list = pro.getAllProvince();
                JSONArray jsonArray = JSONArray.fromObject(list);
                resp.getWriter().println(jsonArray.toString());
                break;
            case "/ajax/city.city":
                //获取前端发送的省对应的编码
                String province = req.getParameter("code");
                List<City> list1 = city.getAllCityByProvince(province);
//                System.out.println(list1);
                JSONArray jsonArray1 = JSONArray.fromObject(list1);
                resp.getWriter().println(jsonArray1.toString());
                break;
            case "/ajax/area.city":
                String city = req.getParameter("code2");
                List<Area> list2 = area.getAllAreaByCity(city);
//                System.out.println(list2);
                JSONArray jsonArray2 = JSONArray.fromObject(list2);
                resp.getWriter().println(jsonArray2.toString());
                break;
        }
    }
}
