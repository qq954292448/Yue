package com.diaoruifeng.service;

import com.diaoruifeng.domain.Order;
import com.diaoruifeng.domain.QueryTable;
import com.diaoruifeng.domain.Xiang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    /**
     * 列表页
     * @param pageNum
     * @param pageSize
     * @param queryTable
     * @return
     */
    Page<Order> getorderlist(Integer pageNum, Integer pageSize, QueryTable queryTable);

    /**
     * 添加订单
     * @param order
     * @return
     */
    Order addorder(Order order);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delallorder(String id);

    boolean delorder(Integer id);

    List<Xiang> getxiangbyoid(Integer id);

    Order getorderByid(Integer id);

    Xiang addxiang(Xiang xian);

    Order save(Order order);

    boolean delxiangbyid(Integer id);

    Xiang selectxiangbyid(Integer id);
}
