package cn.com.jsj.service.impl;

import cn.com.jsj.dao.ProductMapper;
import cn.com.jsj.entity.Product;
import cn.com.jsj.service.ProductService;
import cn.com.jsj.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }

    @Override
    public Product findOne(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public Product save(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return productMapper.selectByProductName(productName);
    }

    @Override
    public void deleteById(String id) {
        productMapper.deleteByPrimaryKey(id);
    }


}
