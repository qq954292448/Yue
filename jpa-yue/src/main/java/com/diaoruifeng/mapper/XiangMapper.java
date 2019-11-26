package com.diaoruifeng.mapper;

import com.diaoruifeng.domain.Order;
import com.diaoruifeng.domain.Xiang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface XiangMapper  extends JpaRepository<Xiang,Integer>, JpaSpecificationExecutor<Xiang> {
    @Query(nativeQuery = true,value = " delete from yue_xiang where oid = ?")
    void delallorder(@Param("id") Integer id);
    @Query(nativeQuery = true,value = " select *  from  yue_xiang where oid = ?1")
    List<Xiang> getxiangbyoid(Integer id);
    @Query(nativeQuery = true,value = " select *  from  yue_xiang where id = ?1")
    Xiang selectxiangbyid(Integer id);
}
