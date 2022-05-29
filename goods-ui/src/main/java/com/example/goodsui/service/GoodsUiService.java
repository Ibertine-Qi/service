package com.example.goodsui.service;

import com.example.goodscommons.entity.Book;
import com.example.goodscommons.vo.ResultVo;

import java.util.List;

public interface GoodsUiService {

    void testGoodsProvider();

    List<Book> getBookList();

    ResultVo queryById(Integer id);
}
