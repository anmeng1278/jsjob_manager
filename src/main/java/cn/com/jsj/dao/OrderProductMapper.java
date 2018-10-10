package cn.com.jsj.dao;

import cn.com.jsj.entity.OrderProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    OrderProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);

    int productInventory(String productId);

    List<OrderProduct> selectAll();
}