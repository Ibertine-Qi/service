package com.example.goodsprovider.service;

import com.example.goodscommons.entity.Book;

import java.util.List;

public interface GoodsProviderService {

    List<Book> list();

    Book queryById(Integer id);
}
