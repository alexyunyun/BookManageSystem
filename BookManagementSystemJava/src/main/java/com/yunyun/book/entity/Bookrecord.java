package com.yunyun.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.util.Date;

/**
 * @author 旋木頵頵
 * @date 2021/1/25 17:01
 */
@Entity
@Data
public class Bookrecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String author;
    private String publish;
    private String type;
    private String time;
    private Float price;
}
