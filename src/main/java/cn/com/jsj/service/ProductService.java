package cn.com.jsj.service;

import cn.com.jsj.entity.Product;
import cn.com.jsj.vo.ProductVO;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findOne(String productId);

    Product save(Product product);

    List<Product> findByProductName(String productName);

    void deleteById(String id);

}
