package cn.com.jsj.entity;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;

    private String userId;

    private Integer totalFee;

    private Date paytime;

    private Byte status;

    private String outTradeNo;

    private String transactionId;

    private String receiveCouponId;

    private Integer couponPrice;

    private Date createDate;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private List<Product> products;

}