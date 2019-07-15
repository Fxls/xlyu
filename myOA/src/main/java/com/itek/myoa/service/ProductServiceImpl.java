/**
 * @Author xlyu
 * @Date 2019/7/12
 * @Description
 */
package com.itek.myoa.service;

import com.itek.myoa.dao.ProductMapper;
import com.itek.myoa.domain.Product;
import com.itek.myoa.domain.ProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: myOA
 * @description:
 * @author: xlYu
 * @create: 2019-07-12 12:08
 **/
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public boolean isHaveThisProduction(String proName) {
        ProductExample exam = new ProductExample();
        exam.createCriteria().andProdNameEqualTo(proName);
        List<Product> list = productMapper.selectByExample(exam);
        if (list == null || list.isEmpty()) {
            return false;
        }
        return true;
    }
}
