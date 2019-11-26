package com.diaoruifeng.mapper;

import com.diaoruifeng.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface OrderMapper extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {
    @Query(nativeQuery=true, value = "select * from yue_order where id = ?1")
    Order findallById(Integer id);

//    @Query(nativeQuery=true,value = "delete from  yue_order  where id  in(?1);")
//    void delallorder(String[] ids);
}
