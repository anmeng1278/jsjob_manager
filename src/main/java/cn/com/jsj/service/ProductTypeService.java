package cn.com.jsj.service;

import cn.com.jsj.entity.ProductType;

import java.util.List;

public interface ProductTypeService {

    List<ProductType> findAll();

    ProductType findByProductTypeName(String id);
}
