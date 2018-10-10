package cn.com.jsj.form;

import lombok.Data;

@Data
public class OrderForm {

    private String userId;
    private String openid;
    private String productId;
    private Integer count;
    private String receiveCouponId;

    @Override
    public String toString() {
        return "OrderForm{" +
                "userId='" + userId + '\'' +
                ", openid='" + openid + '\'' +
                ", productId='" + productId + '\'' +
                ", count=" + count +
                ", receiveCouponId='" + receiveCouponId + '\'' +
                '}';
    }
}

