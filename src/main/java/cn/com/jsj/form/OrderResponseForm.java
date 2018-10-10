package cn.com.jsj.form;

import lombok.Data;

@Data
public class OrderResponseForm {

    /**
     * 订单编号
     */
    private String outTradeNo;
    /**
     * 订单ID
     */
    private String id;
    private String payTime;
    private int totalFee;
    /**购买的商品列表*/
    //private List<ProductResponseForm> products;


}

