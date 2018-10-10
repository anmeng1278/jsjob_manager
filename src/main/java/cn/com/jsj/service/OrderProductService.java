package cn.com.jsj.service;

import cn.com.jsj.entity.OrderProduct;

import java.util.List;

public interface OrderProductService {

    //计算产品剩余量
    int calcProductInventory(String productId);

    List<OrderProduct> findAll();
}
