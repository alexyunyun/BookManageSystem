package com.yunyun.book.repository;

import com.yunyun.book.entity.Bookrecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 旋木頵頵
 * @date 2021/1/25 17:04
 */
public interface BookRepository extends JpaRepository<Bookrecord,Integer> {
}
