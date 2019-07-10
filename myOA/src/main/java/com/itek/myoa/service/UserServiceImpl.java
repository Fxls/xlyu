/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.UserMapper;
import com.itek.myoa.domain.User;
import com.itek.myoa.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-08 15:57
 **/
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String insertUser(User user) {
        int count = userMapper.insert(user);
        if (count > 0) {
            return "用户新增成功";
        }
        return "用户新增失败";
    }

    @Override
    public Integer getId(String applyerName) {
        UserExample exam = new UserExample();
        exam.createCriteria().andNameEqualTo(applyerName);
        List<User> list = userMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            return -1;
        } else {
            return list.get(0).getId();
        }
    }
}
