package com.example.springboot.database.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 类职责：<br/>
 *
 * <p>Title: Role.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年11月16日 下午下午 5:58
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
