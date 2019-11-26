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

    /**
     * 删除订单
     * @param id
     * @return
     */
    boolean delorder(Integer id);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    List<Xiang> getxiangbyoid(Integer id);

    /**
     * genjuid获取订单
     * @param id
     * @return
     */
    Order getorderByid(Integer id);

    /**
     * 添加xiang
     * @param xian
     * @return
     */
    Xiang addxiang(Xiang xian);

    /**
     * 保存 与删除
     * @param order
     * @return
     */
    Order save(Order order);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delxiangbyid(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Xiang selectxiangbyid(Integer id);
}
