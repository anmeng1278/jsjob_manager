package cn.com.jsj.controller;

import cn.com.jsj.dto.OrderDTO;
import cn.com.jsj.entity.Order;
import cn.com.jsj.exception.JsjException;
import cn.com.jsj.service.OrderProductService;
import cn.com.jsj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/order")
@Controller
@Slf4j
public class OrderController {

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private OrderService orderService;

    //查询订单产品列表
    public ModelAndView findOrderProduct(OrderDTO orderDTO, Map<String, Object> map) {
        List<OrderDTO> orderProductList = orderService.findOrderProduct(orderDTO);
        map.put("orderProductList", orderProductList);
        return new ModelAndView("admin/ROrderProduct/index", map);
    }

    /**
     * 订单详情
     *
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        Order order = new Order();
        try {
            order = orderService.findOrderById(orderId);
        } catch (JsjException e) {
            log.error("【查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/jsjob_manager/admin/TOrder/index");
            return new ModelAndView("common/error", map);
        }
        map.put("order", order);
        return new ModelAndView("order/detail", map);
    }
}

