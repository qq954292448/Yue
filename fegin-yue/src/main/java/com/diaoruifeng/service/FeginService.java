package com.diaoruifeng.service;

import com.diaoruifeng.domain.Order;
import com.diaoruifeng.domain.QueryTable;
import com.diaoruifeng.domain.Xiang;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "jpaserver")
@RequestMapping("order")
public interface FeginService {

        /**
         * 列表页
         * @param pageNum
         * @param pageSize
         * @param queryTable
         * @return
         */
        @RequestMapping("getorderlist")
        Page<Order> getorderlist(Integer pageNum, Integer pageSize, QueryTable queryTable);

        /**
         * 添加订单
         * @param order
         * @return
         */
        @RequestMapping("addorder")
        Order addorder(Order order);

        /**
         * 删除
         * @param id
         * @return
         */
        @RequestMapping("delallorder")
        boolean delallorder(String id);

        /**
         * 删除订单
         * @param id
         * @return
         */
        @RequestMapping("delorder")
        boolean delorder(Integer id);

        /**
         * 根据id获取
         * @param id
         * @return
         */
        @RequestMapping("getxiangbyoid")
        List<Xiang> getxiangbyoid(Integer id);

        /**
         * genjuid获取订单
         * @param id
         * @return
         */
        @RequestMapping("getorderByid")
        Order getorderByid(Integer id);

        /**
         * 添加xiang
         * @param xian
         * @return
         */
        @RequestMapping("addxiang")
        Xiang addxiang(Xiang xian);

        /**
         * 保存 与删除
         * @param order
         * @return
         */
        @RequestMapping("save")
        Order save(Order order);

        /**
         * 删除
         * @param id
         * @return
         */
        @RequestMapping("delxiangbyid")
        boolean delxiangbyid(Integer id);

        /**
         * 根据id查询
         * @param id
         * @return
         */
        @RequestMapping("selectxiangbyid")
        Xiang selectxiangbyid(Integer id);


}
