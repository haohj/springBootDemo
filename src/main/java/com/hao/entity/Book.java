package com.hao.entity;

import javax.persistence.*;

/**
 * 图书实体
 * 用于图书的增删改查案例
 */
@Entity
@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String bookName;

    @Column(length = 50)
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
