package com.example.booksui.feign;

import com.example.goodscommons.entity.Book;
import com.example.goodscommons.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "books-provider",fallback = BooksUiFeignImpl.class)
public interface BooksUiFeign {

    @GetMapping("/books/queryAll")
    List<Book> queryAll();

    @GetMapping("/books/queryById")
    ResultVo queryById(@RequestParam("id") Integer id);
}
