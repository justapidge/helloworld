package com.iweb.entity;

import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/14 19:45
 */
@lombok.Data
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String address;
    private Long qqnumber;
    private List<Grade> grades;
}
