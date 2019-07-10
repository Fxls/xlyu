/**
 * @Author xlyu
 * @Date 2019/7/9
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.UserMapper;
import com.itek.myoa.domain.User;
import com.itek.myoa.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-09 15:36
 **/
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> checkUser(User user) {
        UserExample exam = new UserExample();
        exam.createCriteria().
                andLoginNameEqualTo(user.getLoginName()).
                andLoginPwdEqualTo(user.getLoginPwd());
        List<User> list = userMapper.selectByExample(exam);
        if (list==null||list.isEmpty()){
            return null;
        }
        return list;
    }
}
