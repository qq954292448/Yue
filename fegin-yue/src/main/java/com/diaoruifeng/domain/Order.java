package com.diaoruifeng.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "yue_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 3667293199704032504L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderid;
    private String shouname;
    private String shouphone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shoudate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fadate;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderid='" + orderid + '\'' +
                ", shouname='" + shouname + '\'' +
                ", shouphone='" + shouphone + '\'' +
                ", shoudate=" + shoudate +
                ", fadate=" + fadate +
                '}';
    }
}
