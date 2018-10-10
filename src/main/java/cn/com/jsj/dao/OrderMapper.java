package cn.com.jsj.dao;

import cn.com.jsj.dto.OrderDTO;
import cn.com.jsj.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);


    List<OrderDTO> selectOrderProduct();
}