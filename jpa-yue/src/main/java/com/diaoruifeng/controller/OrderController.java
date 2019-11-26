package com.diaoruifeng.controller;

import com.diaoruifeng.domain.Order;
import com.diaoruifeng.domain.QueryTable;
import com.diaoruifeng.domain.Xiang;
import com.diaoruifeng.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表展示
     * @param pageNum
     * @param pageSize
     * @param queryTable
     * @return
     */
    @RequestMapping("getorderlist")
    public Page<Order> getorderlist(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5")Integer pageSize, QueryTable queryTable){

        return orderService.getorderlist(pageNum,pageSize,queryTable);
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    @RequestMapping("addorder")
    public boolean addorder(@RequestBody Order order){
        return orderService.addorder(order)!=null;
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delallorder")
    public boolean delallorder(String id){
        return orderService.delallorder(id);
    }
    //单删
    @RequestMapping("delorder")
    public boolean delorder(Integer id){
        return orderService.delorder(id);
    }

    @RequestMapping("getorderByid")
    public Order getorderByid(Integer id){
        return orderService.getorderByid(id);
    }

    @RequestMapping("getxiangbyoid")
    public List<Xiang> getxiang(Integer id){
        System.out.println(id);
        return orderService.getxiangbyoid(id);
    }
    @RequestMapping("addxiang")
    public boolean addxiang(@RequestBody  Xiang xiang){

        return orderService.addxiang(xiang)!=null;
    }
    @RequestMapping("save")
    public boolean save(@RequestBody  Order order){

        return orderService.save(order)!=null;
    }
    @RequestMapping("delxiangbyid")
    public boolean save(Integer id){

        return orderService.delxiangbyid(id);
    }
    @RequestMapping("selectxiangbyid")
    public Xiang selectxiangbyid(Integer id){

        return orderService.selectxiangbyid(id);
    }

}
