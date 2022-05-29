package com.example.booksui.controller;

import com.example.booksui.feign.BooksUiFeign;
import com.example.goodscommons.entity.Book;
import com.example.goodscommons.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("books")
public class BooksUiController {
    @Resource
    private BooksUiFeign booksUiFeign;

    @GetMapping("/queryAll")
    public List<Book> queryAll(){
        return booksUiFeign.queryAll();
    }

    @GetMapping("/queryById/{id}")
    public ResultVo queryById(@PathVariable("id")Integer id){
        ResultVo resultVo = booksUiFeign.queryById(id);
        return  ResultVo.ok(resultVo);
    }
}
