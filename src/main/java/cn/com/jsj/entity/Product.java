package cn.com.jsj.entity;

import cn.com.jsj.vo.ProductVO;
import lombok.Data;

import java.util.Date;
@Data
public class Product {
    private String id;

    private String typeId;

    private String title;

    private String cover;

    private Integer price;

    private Integer originalCost;

    private Integer total;

    private Integer priority;

    private Boolean distribution;

    private String picture;

    private String unit;

    private Date createDate;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String giftCopywriting;

    private Boolean extraction;

    private String introduce;

    private String instruction;

    private ProductType productType;

    private ProductVO productVO;
}