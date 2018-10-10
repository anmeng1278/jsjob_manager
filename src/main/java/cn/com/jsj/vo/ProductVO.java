package cn.com.jsj.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ProductVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("title")
    private String productTypeName;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("originalCost")
    private Integer originalPrice;

    @JsonProperty("title")
    private String productName;

    @JsonProperty("total")
    private String productStock;

    @JsonProperty("distribution")
    private Boolean isDistribute;

    @JsonProperty("createDate")
    private Date createDate;

    @JsonProperty("updateDate")
    private Date updateDate;

    @JsonProperty("delFlag")
    private String delFlag;

    @JsonProperty("extraction")
    private Boolean isExtract;


}
