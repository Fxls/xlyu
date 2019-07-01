/**
 * @Author xlyu
 * @Date 2019/7/1
 * @Description
 */
package com.itek.spring.day05.controller;

import com.itek.spring.day05.domain.Fee;
import com.itek.spring.day05.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: springDay05
 * @description:
 * @author: xlYu
 * @create: 2019-07-01 16:10
 **/
@Controller
@RequestMapping("fee")
public class FeeController {
    @Autowired
    @Qualifier("feeService")
    private FeeService feeService;

    @RequestMapping("list")
    public String feeList(Model model) {
        List<Fee> list = feeService.getFeeInfo();
        model.addAttribute("clazzCost","sort_asc");
        model.addAttribute("clazzTime","sort_asc");
        model.addAttribute("feeInfo", list);
        return "fee/list";
    }

    @RequestMapping("sort")
    public String sort(HttpServletRequest req, Model model) {
        String sortName = req.getParameter("sortName");
        String[] strArr = sortName.split("_");
        String cost = "cost";
        String time = "time";
        String desc = "DESC";
        String asc = "ASC";

        System.out.println(strArr[1]);
        if (cost.equals(strArr[0])) {
            List<Fee> list = feeService.sortForBaseCost(strArr[1]);
            model.addAttribute("feeInfo", list);

            if (desc.equals(strArr[1])) {
                model.addAttribute("clazzCost", "sort_asc");
                model.addAttribute("clazzTime", "sort_asc");
            }
            if (asc.equals(strArr[1])) {
                model.addAttribute("clazzCost","sort_desc");
                model.addAttribute("clazzTime","sort_desc");
            }

        }

        if (time.equals(strArr[0])) {
            List<Fee> list = feeService.sortForBaseTime(strArr[1]);
            model.addAttribute("feeInfo", list);

            if (desc.equals(strArr[1])) {
                model.addAttribute("clazzCost", "sort_asc");
                model.addAttribute("clazzTime", "sort_asc");
            }
            if (asc.equals(strArr[1])) {
                model.addAttribute("clazzCost","sort_desc");
                model.addAttribute("clazzTime","sort_desc");
            }
        }



        return "fee/list";
    }
}
