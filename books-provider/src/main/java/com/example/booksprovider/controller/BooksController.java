package com.example.booksprovider.controller;

import com.example.booksprovider.dao.BooksDao;
import com.example.goodscommons.entity.Book;
import com.example.goodscommons.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Books)表控制层
 *
 * @author makejava
 * @since 2022-05-13 12:23:33
 */
@RestController
@RequestMapping("books")
public class BooksController {
    @Resource
    private BooksDao booksDao;

    @GetMapping("/queryAll")
    public List<Book> queryAll() {
        return booksDao.queryAll();
    }

    @GetMapping("/queryById")
    public ResultVo queryById(@RequestParam("id") Integer id){
    try{
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        Book book = booksDao.queryById(id);
            return ResultVo.ok(book);
    }

}
