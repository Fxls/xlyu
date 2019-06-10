/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */

package com.iek.netctoss.service;

import com.iek.netctoss.commons.ServiceResult;
import com.iek.netctoss.dao.impl.AdminInter;
import com.iek.netctoss.dao.inter.AdminImpl;

import com.iek.netctoss.module.User;
import com.iek.netctoss.util.GetSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-10 15:48
 **/

public class LoginServiceImpl implements LoginService {


    private AdminInter adminInter = new AdminImpl();

    @Override
    public ServiceResult<User> result(String name, String pwd, String cap) {
        ServiceResult result = new ServiceResult();
        GetSession getSession = new GetSession();
//        HttpServletRequest request = ServletActionContext.getRequest();
//        request.getSession();


        String formName = "[a-z]{2,7}";
        String formPwd = "[a-z]{2,7}";



        String capStr = ((String) getSession.getSession().getAttribute("cap")).toLowerCase();
        String capForm = ((String) session.getAttribute("capStr")).toLowerCase();
        String loginName = (String) session.getAttribute("loginName");
        String loginPwd = (String) session.getAttribute("loginPwd");
        User loginedUser = adminInter.getInfo(name, pwd);

        //TODO 表单正则校验
        //TODO 验证码校验
        if (loginName == null || loginPwd == null) {
            result.setMsg("请输入用户名或密码！");
        } else if (!loginName.matches(formName)) {
            result.setMsg("用户名格式不正确！");
        } else if (!loginPwd.matches(formPwd)) {
            result.setMsg("密码格式不正确！");
        }  else if (!capStr.equals(capForm)) {
            result.setMsg("×");
        } else if (loginedUser == null) {
            //登录失败了
            result.setMsg("登录失败，用户名或密码错误！");
            result.setSuccess(false);
        } else {
            result.setData(loginedUser);
        }
        return result;


    }
}
