package cn.com.jsj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductType {
    private String id;

    @JsonProperty("typeTitle")
    private String typeTitle;

    private Date createDate;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String introduce;

    private String instruction;

    private List<Product> productList;

}