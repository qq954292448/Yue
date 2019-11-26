package com.diaoruifeng.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class QueryTable {
    private String orderid;
    private String shouname;
    private String shouphone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shoustart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shouend;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fastart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date faend;

}
