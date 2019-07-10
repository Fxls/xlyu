/**
 * @Author xlyu
 * @Date 2019/7/8
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.MenuMapper;
import com.itek.myoa.domain.Menu;
import com.itek.myoa.domain.MenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-08 18:04
 **/
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public String insertMenu(Menu menu) {
        int count = menuMapper.insert(menu);
        if (count > 0) {
            return "菜单插入成功";
        }
        return "菜单插入失败";
    }

    @Override
    public List<Menu> getMenu() {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andParentIdIsNull();
        List<Menu> list = menuMapper.selectByExample(menuExample);
        return list;
    }

    @Override
    public List<Menu> getSonMenu(String parentId) {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andParentIdEqualTo(Integer.valueOf(parentId));
        List<Menu> list = menuMapper.selectByExample(menuExample);
        return list;
    }

    @Override
    public List<Menu> getTopMenuByLoginName(String loginName) {
        List<Menu> list = menuMapper.selectTopMenuByLoginName(loginName);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Menu> getSonMenuByLoginNameAndParentId(String parentId, String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", Integer.parseInt(parentId));
        map.put("name", name);
        List<Menu> list = menuMapper.selectSonMenuByLoginNameAndParentId(map);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }
}
