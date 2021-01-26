package com.yunyun.book.controller;

import com.yunyun.book.entity.Bookrecord;
import com.yunyun.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 旋木頵頵
 * @date 2021/1/25 17:11
 */
@SpringBootTest
class BookHandlerTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    void testFindAll() {

        System.out.println(bookRepository.findAll());
    }
    @Test
    void save() {
        Bookrecord bookrecord = new Bookrecord();
        bookrecord.setAuthor("旋木");
        bookrecord.setName("这是一本测试");
        bookrecord.setPublish("IDEA出版社");
        bookrecord.setTime("2020-01-26");
        bookrecord.setPrice(98F);
        bookRepository.save(bookrecord);
    }

    @Test
    void delete() {
        bookRepository.deleteById(35);
    }

}