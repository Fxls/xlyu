/**
 * @Author xlyu
 * @Date 2019/6/10
 * @Description
 */

package com.iek.netctoss.service.impl;

import com.iek.netctoss.commons.ServiceResult;
import com.iek.netctoss.dao.inter.AdminInter;
import com.iek.netctoss.dao.impl.AdminImpl;

import com.iek.netctoss.module.User;
import com.iek.netctoss.service.inter.LoginService;

import javax.servlet.http.HttpServletRequest;


/**
 * @program: netctoss
 * @description:
 * @author: xlyu
 * @create: 2019-06-10 15:48
 **/

public class LoginServiceImpl implements LoginService {


    private AdminInter adminInter = new AdminImpl();

    @Override
    public ServiceResult<User> result(HttpServletRequest req, String name, String pwd, String cap) {
        ServiceResult result = new ServiceResult();
        String capStr = (String) req.getSession().getAttribute("capStr");

        String formName = "[a-z]{2,7}";
        String formPwd = "[a-z]{2,7}";

        User loginedUser = adminInter.getInfo(name, pwd);

        if (name == null || pwd == null) {
            result.setMsg("用户名或密码不能为空");
            result.setSuccess(false);
        } else if (!name.matches(formName) || !pwd.matches(formPwd)) {
            result.setMsg("用户名或密码格式错误");
            result.setSuccess(false);
        } else if (!(cap.toLowerCase()).equals(capStr.toLowerCase())) {
            result.setMsg("×");
            result.setSuccess(false);
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
