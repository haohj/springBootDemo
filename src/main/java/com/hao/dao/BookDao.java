package com.hao.dao;

import com.hao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    @Query("select b from t_book b where b.book_name like '%?1%'")
    public List<Book> findByName(String bookName);

    @Query(value = "select * from t_book order by rand() limit ?1", nativeQuery = true)
    public List<Book> randomList(Integer n);
}
