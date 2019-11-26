package com.diaoruifeng.service;

import com.diaoruifeng.domain.Order;
import com.diaoruifeng.domain.QueryTable;
import com.diaoruifeng.domain.Xiang;
import com.diaoruifeng.mapper.OrderMapper;
import com.diaoruifeng.mapper.XiangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements  OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private XiangMapper xiangMapper;
    @Override
    public Page<Order> getorderlist(Integer pageNum, Integer pageSize, QueryTable queryTable) {
        Pageable of = PageRequest.of(pageNum - 1, pageSize);
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> predicateArrayList = new ArrayList<>();
                if (!StringUtils.isEmpty(queryTable.getOrderid())){
                    Predicate like = criteriaBuilder.like(root.get("orderid"), "%" + queryTable.getOrderid() + "%");
                    predicateArrayList.add(like);
                }
                if (!StringUtils.isEmpty(queryTable.getShouname())){
                    Predicate like = criteriaBuilder.like(root.get("shouname"), "%" + queryTable.getShouname() + "%");
                    predicateArrayList.add(like);
                }
                if (!StringUtils.isEmpty(queryTable.getShouphone())){
                    Predicate like = criteriaBuilder.like(root.get("shouphone"), "%" + queryTable.getShouphone() + "%");
                    predicateArrayList.add(like);
                }
                if (!StringUtils.isEmpty(queryTable.getShoustart()) && !StringUtils.isEmpty(queryTable.getShouend())){
                    Predicate like = criteriaBuilder.between(root.get("shoudate"),queryTable.getShoustart(),queryTable.getShouend());
                    predicateArrayList.add(like);
                }
                if (!StringUtils.isEmpty(queryTable.getFastart()) && !StringUtils.isEmpty(queryTable.getFaend())){
                    Predicate like = criteriaBuilder.between(root.get("shoudate"),queryTable.getFastart(),queryTable.getFaend());
                    predicateArrayList.add(like);
                }
                Predicate[] predicates = new Predicate[predicateArrayList.size()];
                predicates = predicateArrayList.toArray(predicates);
                Predicate and = criteriaBuilder.and(predicates);
                return and;
            }
        };
        Page<Order> all = orderMapper.findAll(specification,of);
        return all;
    }

    @Override
    public Order addorder(Order order) {
        Order save = orderMapper.save(order);
        return save;
    }

    @Override
    public boolean delallorder(String id) {
        System.out.println("id:"+id);
        String[] ids = id.split(",");
        System.out.println("ids:"+ids);
        for (int i = 0 ; i< ids.length ; i++){
            orderMapper.deleteById(Integer.parseInt(ids[i]));
        }
//        for (int i = 0 ; i< ids.length ; i++){
//            xiangMapper.delallorder(Integer.parseInt(ids[i]));
//        }
        //.delalorder(strings);
        return true;
    }

    @Override
    public boolean delorder(Integer id) {
        orderMapper.deleteById(id);
       // xiangMapper.delallorder(id);
        return true;
    }

    @Override
    public List<Xiang> getxiangbyoid(Integer id) {
        List<Xiang> xiangList=xiangMapper.getxiangbyoid(id);
        return xiangList;
    }

    @Override
    public Order getorderByid(Integer id) {
        Order byId = orderMapper.findallById(id);
        return byId;
    }

    @Override
    public Xiang addxiang(Xiang xiang) {
        //System.out.println("xiang:"+xiang);
       // System.out.println("oid:"+oid);
        Integer oid = xiang.getOids();
        Order byId = orderMapper.findallById(oid);
        System.out.println("byId:"+byId);
        xiang.setOrder(byId);
        Xiang save = xiangMapper.save(xiang);
        return save;
    }

    @Override
    public Order save(Order order) {
        Order save = orderMapper.save(order);
        return save;
    }

    @Override
    public boolean delxiangbyid(Integer id) {
        xiangMapper.deleteById(id);
        return true;
    }

    @Override
    public Xiang selectxiangbyid(Integer id) {
        Xiang xiang =xiangMapper.selectxiangbyid(id);
        return xiang;
    }
}
