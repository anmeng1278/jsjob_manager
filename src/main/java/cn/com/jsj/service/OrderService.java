package cn.com.jsj.service;

import cn.com.jsj.dto.OrderDTO;
import cn.com.jsj.entity.Order;

import java.util.List;

public interface OrderService {

    Order findOrderById(String orderId);

    List<OrderDTO> findOrderProduct(OrderDTO orderDTO);
}
