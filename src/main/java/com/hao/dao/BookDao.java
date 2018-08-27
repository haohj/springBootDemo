package com.hao.dao;

import com.hao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Administrator
 * 继承JpaRepository可以实现图书基本的增删改查
 * 继承JpaSpecificationExecutor用于实现图书的动态查询
 */
public interface BookDao extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    /**
     * 使用HQL查询
     *
     * @param bookName
     */
    @Query("select b from Book b where b.bookName like '%?1%'")
    public List<Book> findByName(String bookName);

    /**
     * 使用原生SQL查询
     *
     * @param n
     */
    @Query(value = "select * from t_book order by rand() limit ?1", nativeQuery = true)
    public List<Book> randomList(Integer n);

}
