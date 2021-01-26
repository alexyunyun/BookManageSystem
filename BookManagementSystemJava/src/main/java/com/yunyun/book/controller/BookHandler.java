package com.yunyun.book.controller;

import com.yunyun.book.entity.Bookrecord;
import com.yunyun.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author 旋木頵頵
 * @date 2021/1/25 17:03
 */
@RestController
@RequestMapping("/book")
public class BookHandler {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Bookrecord> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Bookrecord bookrecord) {
        Bookrecord result = bookRepository.save(bookrecord);
        if (result != null) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("/findById/{id}")
    public Bookrecord findById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("/update")
    public String update(@RequestBody Bookrecord bookrecord) {
        if (save(bookrecord) != null){
            return "success";
        }
        return "fail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
        if (bookRepository.findById(id).isPresent()) {
            return "fail";
        }
        return "success";
    }
}


