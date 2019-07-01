/**
 * @Author xlYu
 * @Date 2019/6/11
 * @Description
 */
package com.itek.spring.day05.service;

import com.itek.spring.day05.dao.AdminInter;
import com.itek.spring.day05.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: netctoss
 * @description:
 * @author: xlYu
 * @create: 2019-06-11 08:57
 **/
@Service("menu")
public class MenuServiceImpl implements MenuService {
    @Autowired
    @Qualifier("adminDao")
    private AdminInter adminInter ;

    @Override
    public List<Menu> selectMenusByUserId(Integer id) {
        return adminInter.getMenuById(id);
    }
}
