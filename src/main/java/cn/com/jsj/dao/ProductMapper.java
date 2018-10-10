package cn.com.jsj.dao;

import cn.com.jsj.entity.Product;
import cn.com.jsj.vo.ProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(Product record);

    List<Product> selectAll();

    Product selectByPrimaryKey(String productId);

    Product insert(Product product);

    List<Product> selectByProductName(String productName);
}