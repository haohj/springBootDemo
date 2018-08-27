package com.hao.controller;

import com.hao.dao.BookDao;
import com.hao.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookDao bookDao;

    /**
     * 查询所有图书
     *
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView bookList() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bookList", bookDao.findAll());
        mv.setViewName("bookList");
        return mv;
    }

    /**
     * 根据条件动态查询
     *
     * @param book
     * @return
     */
    public ModelAndView bookList2(Book book) {
        ModelAndView mv = new ModelAndView();

        List<Book> bookList = bookDao.findAll(new Specification<Book>() {

            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (book != null) {
                    if (book.getBookName() != null && !"".equals(book.getBookName())) {
                        predicate.getExpressions().add(cb.like(root.get("name"), "%" + book.getBookName() + "%"));
                    }
                    if (book.getAuthor() != null && !"".equals(book.getAuthor())) {
                        predicate.getExpressions().add(cb.like(root.get("author"), "%" + book.getAuthor() + "%"));
                    }
                }
                return predicate;
            }
        });

        mv.addObject("bookList", bookList);
        mv.setViewName("bookList");
        return mv;
    }


    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Book book) {
        bookDao.save(book);
        return "forward:/book/list";
    }

    /**
     * 根据id查询book实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/preUpdate/{id}")
    public ModelAndView preUpdate(@PathVariable(value = "id") Integer id) {
        ModelAndView mv = new ModelAndView();
        if (id == null) {
            mv.addObject("errMsg", "id为空！");
            mv.setViewName("error");
        } else {
            Book book = bookDao.getOne(id);
            mv.addObject("book", book);
            mv.setViewName("bookUpdate");
        }

        return mv;
    }


    /**
     * 修改图书
     *
     * @param book
     * @return
     */
    @PostMapping("/update")
    public String update(Book book) {
        bookDao.save(book);
        return "forward:/book/list";
    }

    /**
     * 删除图书
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        bookDao.deleteById(id);
        return "forward:/book/list";
    }

    /**
     * 根据图书名称模糊查询
     *
     * @param bookName
     * @return
     */
    @RequestMapping("/queryByBookName")
    public ModelAndView queryByBookName(String bookName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bookList", bookDao.findAll());
        mv.setViewName("bookList");
        return mv;
    }

    /**
     * 随机查询两条图书记录
     *
     * @return
     */
    @GetMapping("/randomList")
    public ModelAndView randomList() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bookList", bookDao.randomList(2));
        mv.setViewName("bookList");
        return mv;
    }
}
