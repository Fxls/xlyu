/**
 * @Author xlyu
 * @Date 2019/6/29
 * @Description
 */
package com.itek.spring.day05.service;


import com.itek.spring.day05.commons.CheckResult;
import com.itek.spring.day05.commons.ResultEnum;
import com.itek.spring.day05.dao.UserDao;
import com.itek.spring.day05.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springDay04
 * @description:
 * @author: xlYu
 * @create: 2019-06-29 15:34
 **/
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    /**
     * 自动装配（不要忘记组件扫描）
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;


    @Override
    public CheckResult<User> checkUser(User user, HttpServletRequest req, String capInput) {

        /**
         * 对验证码进行校验(此处得到的是正确验证码字符串)
         */
        String capStr = (String) req.getSession().getAttribute("capStr");


        /**
         * 使用登录校验的结果集对数据处理结果进行封装
         */
        CheckResult<User> result = new CheckResult<>();
        User user1 = userDao.selectByUser(user);
        result.setData(user1);
        /**
         * 返回结果是null则说明查询失败，即用户名or密码错误，绑定错误信息...
         */
        if (!capStr.toLowerCase().equals(capInput.toLowerCase())) {
            result.setCheckResult(ResultEnum.FAILED_OF_CAP);
        }
        if (user1 == null) {
            result.setCheckResult(ResultEnum.FAILED);
        }
        return result;
    }
}
