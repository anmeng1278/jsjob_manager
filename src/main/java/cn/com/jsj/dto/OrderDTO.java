package cn.com.jsj.dto;

import cn.com.jsj.entity.Order;
import cn.com.jsj.entity.OrderProduct;
import cn.com.jsj.entity.User;
import cn.com.jsj.entity.Wechat;
import cn.com.jsj.enums.OrderStatusEnum;
import cn.com.jsj.utils.EnumUtil;
import cn.com.jsj.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class OrderDTO {

    /*ID	昵称	商品名称	商品数量	下单时间	支付时间	支付金额	使用优惠券金额	产生方式*/

    /**
     * 订单id.
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 订单状 0：待支付 1：支付成功 2：支付失败
     */
    private Integer status;

    /**
     * 生成的支付订单流水号
     */
    private String outTradeNo;

    /**
     * 微信的支付订单号
     */
    private String transactionId;

    /**
     * 创建时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 支付时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date paytime;

    /**
     * 更新时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<Order> orderList;

    List<OrderProduct> orderProductList;

    private User user;

    private Wechat wechat;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(status, OrderStatusEnum.class);
    }

}
