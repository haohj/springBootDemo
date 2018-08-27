package com.hao.controller;

import com.hao.dao.BookDao;
import com.hao.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookDao bookDao;

    @RequestMapping("/list")
    public ModelAndView bookList() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bookList", bookDao.findAll());
        mv.setViewName("bookList");
        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Book book) {
        bookDao.save(book);
        return "forward:/book/list";
    }

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


    @PostMapping("/update")
    public String update(Book book) {
        bookDao.save(book);
        return "forward:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        bookDao.deleteById(id);
        return "forward:/book/list";
    }

    @RequestMapping("/queryByBookName")
    public ModelAndView queryByBookName(String bookName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bookList", bookDao.findAll());
        mv.setViewName("bookList");
        return mv;
    }

    @GetMapping("/randomList")
    public ModelAndView randomList() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bookList", bookDao.randomList(2));
        mv.setViewName("bookList");
        return mv;
    }
}
