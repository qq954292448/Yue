package com.diaoruifeng.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "yue_xiang")
public class Xiang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String shopid;
    private String shopname;
    private String shopsize;
    private Integer nums;
    private String shou;
    private String song;
    private Integer yudate;
    private Integer shidate;
    private String contest;
    private Integer oids;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "oid")
    private Order order;
}
