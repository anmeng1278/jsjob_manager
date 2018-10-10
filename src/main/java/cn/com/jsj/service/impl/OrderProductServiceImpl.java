package cn.com.jsj.service.impl;

import cn.com.jsj.dao.OrderProductMapper;
import cn.com.jsj.dao.ProductMapper;
import cn.com.jsj.dao.ProductTypeMapper;
import cn.com.jsj.entity.OrderProduct;
import cn.com.jsj.entity.ProductType;
import cn.com.jsj.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Autowired
    private ProductMapper productMapper;

    /**
     * 计算产品剩余量
     *
     * @param productId
     * @return
     */
    @Override
    public int calcProductInventory(String productId) {
        int inventory = productMapper.selectByPrimaryKey(productId).getTotal()-orderProductMapper.productInventory(productId);
        return inventory;
    }

    @Override
    public List<OrderProduct> findAll() {
        return orderProductMapper.selectAll();
    }
}
