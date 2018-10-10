package cn.com.jsj.service.impl;

import cn.com.jsj.dao.ProductTypeMapper;
import cn.com.jsj.entity.ProductType;
import cn.com.jsj.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> findAll() {
        return productTypeMapper.selectAll();
    }

    @Override
    public ProductType findByProductTypeName(String id) {
        return productTypeMapper.selectByPrimaryKey(id);
    }

}
