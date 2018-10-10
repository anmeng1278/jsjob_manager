package cn.com.jsj.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderProduct {
    private String id;

    private String orderId;

    private String productId;

    private Integer cnt;

    private Byte source;

    private Order order;

    private List<Product> productList;

}