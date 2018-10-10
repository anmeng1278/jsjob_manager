package cn.com.jsj.service.impl;

import cn.com.jsj.dao.OrderMapper;
import cn.com.jsj.dto.OrderDTO;
import cn.com.jsj.entity.Order;
import cn.com.jsj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order findOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<OrderDTO> findOrderProduct(OrderDTO orderDTO) {
        //判断订单状态
        return orderMapper.selectOrderProduct();
    }
}
