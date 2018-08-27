package com.hao.dao;

import com.hao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    @Query("")
    public List<Book> findByName(String bookName);

    @Query("")
    public List<Book> randomList(Integer n);
}
