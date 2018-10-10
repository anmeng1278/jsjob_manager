package cn.com.jsj.form;

import lombok.Data;


@Data
public class ProductForm {

    private String id;
    private String typeId;
    private String title;
    private String productName;
    private Integer price;
    private Integer total;
    private Boolean distribution;
    private String introduce;


}
